/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Processor.OtsuThreshold;
import Processor.conversion;
import Processor.imageProcessor;
import constants.imageConfiguration;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class main_view extends javax.swing.JPanel {
    private conversion imageConv = new conversion();
    private String path_string=  "C:/Users/Andy/Desktop/Portfolio resources/view5.jpg";
    public File images_path = new File(path_string);
    public BufferedImage image;
    imageProcessor ip = new imageProcessor();
    OtsuThreshold otsu;
    int grayscale_level_value = 8; //number of grayscale level, in other word they are number of bars you see in the histogram
    public main_view() {
        initComponents();
        
        try {
            this.image = this.imageConv.conv_StringPathToBufferedImage(this.path_string);
            ImageIcon temp = this.imageConv.conv_BufferedImageToImageIcon(this.image);
            this.original_image.setIcon(temp);
            this.processed_image.setIcon(temp);
        } catch (IOException ex) {
            Logger.getLogger(main_view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        processed_image = new javax.swing.JLabel();
        original_image = new javax.swing.JLabel();
        panel_controller = new javax.swing.JPanel();
        lbl_controller = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_file_path = new javax.swing.JTextField();
        bt_browse = new javax.swing.JButton();
        bt_run = new javax.swing.JButton();
        grayscale_level = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        processed_image.setText("processed_image");

        original_image.setText("original_image");

        lbl_controller.setText("Controller");

        jLabel1.setText("Input Image");

        bt_browse.setText("Browse");
        bt_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_browseActionPerformed(evt);
            }
        });

        bt_run.setText("Run");
        bt_run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_runActionPerformed(evt);
            }
        });

        grayscale_level.setValue(8);

        jLabel2.setText("Grayscale level ");

        javax.swing.GroupLayout panel_controllerLayout = new javax.swing.GroupLayout(panel_controller);
        panel_controller.setLayout(panel_controllerLayout);
        panel_controllerLayout.setHorizontalGroup(
            panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_controllerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_controllerLayout.createSequentialGroup()
                        .addGroup(panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_controller)
                            .addComponent(jLabel1)
                            .addComponent(tf_file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_browse)
                            .addComponent(bt_run)))
                    .addComponent(jLabel2)
                    .addComponent(grayscale_level, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panel_controllerLayout.setVerticalGroup(
            panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_controllerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_controller)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_browse))
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_controllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grayscale_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_run))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_controller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(original_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(processed_image)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(processed_image)
                        .addComponent(original_image))
                    .addComponent(panel_controller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_browseActionPerformed
        //System.out.print(nama);
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image File (*.jpg)", "jpg"));
        chooser.setAcceptAllFileFilterUsed(true);
        int result = chooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            this.path_string = chooser.getSelectedFile().getAbsolutePath();
            this.tf_file_path.setText(this.path_string);
        }
        try {
            this.image = this.imageConv.conv_StringPathToBufferedImage(this.path_string);
            ImageIcon temp = this.imageConv.conv_BufferedImageToImageIcon(this.image);
            this.original_image.setIcon(temp);
            this.processed_image.setIcon(temp);
        } catch (IOException ex) {
            Logger.getLogger(main_view.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bt_browseActionPerformed

    private void bt_runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_runActionPerformed
//        File input = new File(this.path_string);
        this.grayscale_level_value = (int) this.grayscale_level.getValue();
        if(this.grayscale_level_value < 2) {
            System.out.println("Please fill in the level to more than 1");
            System.out.println("Else it can't generate the histogram");
            this.grayscale_level.setValue(2);
        }else {
            image = ip.scale(image, imageConfiguration.IMAGE_HEIGHT, imageConfiguration.IMAGE_WIDTH);
            ArrayList<ArrayList<Double>> display_image = ip.getPixelArrayList(image);
            otsu = new OtsuThreshold(display_image, this.grayscale_level_value);
            otsu.calculateThreshold();
            double threshold = otsu.getThreshold();
            display_image = ip.getBinarizeArrayList(display_image, threshold, imageConfiguration.BLACK_ORI);
            BufferedImage image_after = ip.convertMatToBM(display_image);
            ImageIcon temp = new ImageIcon(image_after);
            this.processed_image.setIcon(temp);
        }
    }//GEN-LAST:event_bt_runActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_browse;
    private javax.swing.JButton bt_run;
    private javax.swing.JSpinner grayscale_level;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_controller;
    private javax.swing.JLabel original_image;
    private javax.swing.JPanel panel_controller;
    private javax.swing.JLabel processed_image;
    private javax.swing.JTextField tf_file_path;
    // End of variables declaration//GEN-END:variables
}
