/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legacy;

/**
 *
 * @author Benjamin
 */
public class MultiMenu extends javax.swing.JDialog {

    /**
     * Creates new form GameMenu
     */
    public MultiMenu(CastleFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menuLayeredPane = new javax.swing.JLayeredPane();
        menuBottomLayer = new javax.swing.JPanel();
        titleBackgroundLabel = new javax.swing.JLabel();
        menuTopLayer = new javax.swing.JPanel();
        singlePlayerButton = new javax.swing.JButton();
        hostButton = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Player Names");

        menuLayeredPane.setMaximumSize(new java.awt.Dimension(1280, 800));
        menuLayeredPane.setMinimumSize(new java.awt.Dimension(1280, 800));

        menuBottomLayer.setMaximumSize(new java.awt.Dimension(1280, 800));
        menuBottomLayer.setMinimumSize(new java.awt.Dimension(1280, 800));
        menuBottomLayer.setPreferredSize(new java.awt.Dimension(1280, 800));

        javax.swing.GroupLayout menuBottomLayerLayout = new javax.swing.GroupLayout(menuBottomLayer);
        menuBottomLayer.setLayout(menuBottomLayerLayout);
        menuBottomLayerLayout.setHorizontalGroup(
            menuBottomLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBackgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        menuBottomLayerLayout.setVerticalGroup(
            menuBottomLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBottomLayerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleBackgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuTopLayer.setFocusable(false);
        menuTopLayer.setMaximumSize(new java.awt.Dimension(1280, 800));
        menuTopLayer.setMinimumSize(new java.awt.Dimension(1280, 800));
        menuTopLayer.setOpaque(false);
        menuTopLayer.setPreferredSize(new java.awt.Dimension(1280, 800));

        singlePlayerButton.setBorderPainted(false);
        singlePlayerButton.setContentAreaFilled(false);
        singlePlayerButton.setFocusPainted(false);
        singlePlayerButton.setMaximumSize(new java.awt.Dimension(170, 45));
        singlePlayerButton.setMinimumSize(new java.awt.Dimension(170, 45));
        singlePlayerButton.setPreferredSize(new java.awt.Dimension(170, 45));
        singlePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleClicked(evt);
            }
        });

        hostButton.setActionCommand("HOST");
        hostButton.setBorderPainted(false);
        hostButton.setContentAreaFilled(false);
        hostButton.setFocusPainted(false);
        hostButton.setMaximumSize(new java.awt.Dimension(91, 45));
        hostButton.setMinimumSize(new java.awt.Dimension(91, 45));
        hostButton.setPreferredSize(new java.awt.Dimension(91, 45));
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkClicked(evt);
            }
        });

        clientButton.setActionCommand("CLIENT");
        clientButton.setBorderPainted(false);
        clientButton.setContentAreaFilled(false);
        clientButton.setFocusPainted(false);
        clientButton.setMaximumSize(new java.awt.Dimension(91, 45));
        clientButton.setMinimumSize(new java.awt.Dimension(91, 45));
        clientButton.setPreferredSize(new java.awt.Dimension(91, 45));
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkClicked(evt);
            }
        });

        javax.swing.GroupLayout menuTopLayerLayout = new javax.swing.GroupLayout(menuTopLayer);
        menuTopLayer.setLayout(menuTopLayerLayout);
        menuTopLayerLayout.setHorizontalGroup(
            menuTopLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTopLayerLayout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(clientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        menuTopLayerLayout.setVerticalGroup(
            menuTopLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTopLayerLayout.createSequentialGroup()
                .addContainerGap(512, Short.MAX_VALUE)
                .addGroup(menuTopLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(243, 243, 243))
        );

        javax.swing.GroupLayout menuLayeredPaneLayout = new javax.swing.GroupLayout(menuLayeredPane);
        menuLayeredPane.setLayout(menuLayeredPaneLayout);
        menuLayeredPaneLayout.setHorizontalGroup(
            menuLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayeredPaneLayout.createSequentialGroup()
                .addComponent(menuBottomLayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(menuLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayeredPaneLayout.createSequentialGroup()
                    .addComponent(menuTopLayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        menuLayeredPaneLayout.setVerticalGroup(
            menuLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayeredPaneLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menuBottomLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayeredPaneLayout.createSequentialGroup()
                    .addComponent(menuTopLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        menuLayeredPane.setLayer(menuBottomLayer, 1);
        menuLayeredPane.setLayer(menuTopLayer, 2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singleClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleClicked
        this.selected = "Single";
        this.setModal(false);
        this.dispose();
    }//GEN-LAST:event_singleClicked

    private void networkClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkClicked
        this.selected = "Multi";
        this.hosting=evt.getActionCommand();
        this.setModal(false);
        this.dispose();
    }//GEN-LAST:event_networkClicked

    public String getDecision() {
        return selected;
    }
    public String getHosting() {
        return hosting;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clientButton;
    private javax.swing.JButton hostButton;
    private javax.swing.JPanel menuBottomLayer;
    private javax.swing.JLayeredPane menuLayeredPane;
    private javax.swing.JPanel menuTopLayer;
    private javax.swing.JButton singlePlayerButton;
    private javax.swing.JLabel titleBackgroundLabel;
    // End of variables declaration//GEN-END:variables
    private String[] players;
    private String selected;
    private String hosting;
}