package com.csci499;

import com.badlogic.gdx.Game;
import com.util.GameType;
import com.util.PlatformType;

public class TerrorGDXGame extends Game {

    public static final String TITLE = "Tower Terror";
    public static final int WIDTH = 1270, HEIGHT = 720; // used later to set window size

    protected GameType gameType;

    private StartScreen startScreen;
    private LocalScreen localScreen;
    private MultiScreen hostScreen;
    private MultiScreen clientScreen;
    private GameScreen gameScreen;
    private EndScreen winScreen;
    private EndScreen loseScreen;
    private AbstractScreen[] screens;


    private GameState gameState; //TODO: Make variable of type GameStateInterface after adding required methods to interface

    private final NetworkHandler p2p;
    private final PlatformType platformType; //we may need this later


    //TODO: One sprite batch for all stages for performance

    public TerrorGDXGame(PlatformType platformType) {
        gameType = GameType.UNKNOWN;
        this.platformType = platformType;
        p2p = new NetworkHandler();
    }

    @Override
    public void create() {
        screens = new AbstractScreen[]{
                startScreen = new StartScreen(),
                localScreen = new LocalScreen(),
                hostScreen = new MultiScreen(true),
                clientScreen = new MultiScreen(false),
                gameScreen = new GameScreen(),
                winScreen = new EndScreen(true),
                loseScreen = new EndScreen(false)
        };
        setScreen(startScreen); //start first screen
    }

    @Override
    public void render() {

        AbstractScreen currentScreen = (AbstractScreen) this.getScreen();

        if (currentScreen.getChange()) { //current screen has signaled to change screens
            switch (currentScreen.getChangeScreen()) { //switch on which screen current screen signals to change to
                case UNKNOWN:
                    System.err.println("ERROR -- TERRORGDXGAME -- RENDER -- CALLED CHANGE SCREEN WITHOUT SETTING CHANGE FLAG");
                    throw new IllegalArgumentException("ERROR -- TERRORGDXGAME -- RENDER -- CALLED CHANGE SCREEN WITHOUT SETTING CHANGE FLAG");
                case LOCAL:
                    setScreen(localScreen);
                    gameType = GameType.LOCAL;
                    break;
                case HOSTS:
                    setScreen(hostScreen);
                    gameType = GameType.HOST;

                    break;
                case CLIENTS:
                    setScreen(clientScreen);
                    gameType = GameType.CLIENT;
                    break;

                case GAME:
                    switch (gameType) {
                        case LOCAL:
                            gameState = new GameState(localScreen.getPlayers());
                            break;
                        case HOST:
                            netLauncher();
                            break;
                        case CLIENT:
                            netLauncher();
                            break;
                        default:
                            System.err.println("ERROR -- TERRORGDXGAME -- RENDER -- UKNOWN MULTIPLAYER OPTION");
                            throw new IllegalArgumentException("ERROR -- TERRORGDXGAME -- UNKNOWN MULTIPLAYER OPTION");
                    }
                    setScreen(gameScreen);
                    break;
                case WIN:
                    setScreen(winScreen);
                    break;
                case LOSE:
                    setScreen(loseScreen);
                    break;
                case START:
                    gameType = GameType.UNKNOWN;
                    setScreen(startScreen);
                    break;
                default:
                    System.err.println("ERROR -- TERRORGDXGAME -- RENDER -- UKNOWN CHANGE SCREEN");
                    throw new IllegalArgumentException("ERROR -- TERRORGDXGAME -- UNKNOWN CHANGE SCREEN");

            }

            super.render();
        }
    }

    @Override
    public void dispose() {
        for (AbstractScreen screen : screens) {
            screen.dispose();
        }
    }

    /**
     * netHandler method -- Used to handle starting a P2P networked game using the NetHandler field of this class.
     * Will instantiate a new GameState and store in gameState field if successful.
     */
    private void netLauncher() {
        if (true) {
            throw new UnsupportedOperationException(); //not ready yet -- see TODOs
        }
        //TODO: timeouts?

        String[] players = new String[2]; // two players supported for P2P game
        String port;
        String address;

        switch (gameType) {

            case CLIENT:
                players[0] = clientScreen.getPlayerName();
                port = clientScreen.getPort();
                address = clientScreen.getIP();
                p2p.setLocalActive(false);
                p2p.connectToHost(address, port);

                //Send local name
                p2p.transmitNames(players);
                //Receive name array
                players = p2p.listenForNames();
                try {
                    players[1] = players[1] + " (CLIENT)";
                } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
                    players[0] = "HOST";
                    players[1] = "CLIENT";

                }
                gameState = p2p.listenForState();
                break;

            case HOST:
                p2p.setLocalActive(true);
                players[0] = hostScreen.getPlayerName();
                port = hostScreen.getPort();

                p2p.openHosting(port);
                String[] clientNames = p2p.listenForNames();

                //Listen for client names
                for (String current : clientNames) {
                    System.out.println("MSG -- TERRORGDXGAME -- NETLAUNCHER -- RECEIVED A NAME");
                    System.out.println("DATA: " + current);
                }

                //Add client name to player list
                try {
                    players[1] = clientNames[0];
                } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                    System.err.println("ERROR -- TERRORGDX GAME -- NETLAUNCHER -- RECEIVED INVALID CLIENT NAME ARRAY");
                    players[1] = "DEFAULT";
                }
                //Send names back
                p2p.transmitNames(players);
                players[0] = players[0] + " (HOST)";
                gameState = new GameState(players);
                System.out.println("MSG -- TERRORGDXGAME -- NETLAUNCHER -- ATTEMPTING TO SYNCHRONIZE STATES. . . ");
                p2p.transmitGameState(gameState);

            case UNKNOWN:
                System.err.println("ERROR -- TERRORGDXGAME -- NETLAUNCHER -- UNKNOWN GAMETYPE");
                throw new IllegalArgumentException("ERROR -- TERRORGDXGAME -- UNKNOWN GAMETYPE");
        }
    }

    /*
   Builds and executes a new instance of a Swing worker thread. That will listen for new gameStates until the end of a turn.
   */
    public void buildSpectateThread() {
        /*
        System.out.println("(NET)[SPECTATOR THREAD SPUN]");
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                //deact buttons when not active
                for (JButton button : phaseButtons) {
                    button.setEnabled(net.isLocalActive());
                }
                for (JButton button : skipButtons) {
                    button.setEnabled(net.isLocalActive());
                }
                //print not active to network label
                phaseTitleLabel2.setIcon(spectator);
                System.out.println("(NET) BEGINNING SPECTATING . . .");
                while (!net.isLocalActive()) {
                    gameState = net.listenForState();
                    updateGame();
                    revalidate();
                    paintComponents(getGraphics());
                    net.updateLocalActive(gameState);
                }
                //act buttons when active
                for (JButton button : phaseButtons) {
                    button.setEnabled(net.isLocalActive());
                }
                for (JButton button : skipButtons) {
                    button.setEnabled(net.isLocalActive());
                }
                phaseTitleLabel2.setIcon(activeNow);
                System.out.println("(NET) ENDING SPECTATING . . .");
                return true;
            }
        };
        worker.execute();
    }
*/
    }

}

