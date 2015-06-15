/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medidor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 PROXIMO
Zoom na figura
Translate to two more languages: english and spanish

 Embelezar!!!!
 */
/**
 *
 * @author viniciusduarte
 */
public class MedidorDeRaiz implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private final MotherFrame frame;
    private final PhotoPanel photoPanel;
    private final JPanel otherPanel;
    private final JButton loadPicture, reset, resultButton;
    private final JButton loadNormalizers;
    private final JFileChooser fileChooser;
    private final JTextArea informationText;
    private final TextField tFieldValorX;
    private final TextField tFieldValorY;
    private final JLabel jLabel1, jLabel2;
    private final javax.swing.JScrollPane jScrollPane2;

    private MedidorDeRaiz() {
        Dimension gDimension = new Dimension();
        frame = MotherFrame.getInstance();

        gDimension.height = frame.getHeight();
        gDimension.width = frame.getWidth() / 2;

        photoPanel = new PhotoPanel();
        photoPanel.setPreferredSize(gDimension);

        otherPanel = new JPanel();
        otherPanel.setPreferredSize(gDimension);
        loadPicture = new JButton("Carregar Imagem");
        loadPicture.addActionListener(this);
        //otherPanel.add(loadPicture);

        loadNormalizers = new JButton("Config. x, y");
        loadNormalizers.addActionListener(this);

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        informationText = new JTextArea(18, 20);
        informationText.setEditable(false);
        informationText.setText("Passo 1:\nConfigure parametros iniciais,"
                + "\nPrimeiro horizontalmente,\ndepois verticalmente."
                + "\n\n\n\n\nAutor: Vinícius Duarte Lopes"
                + "\nEmail: vin.duartelopes@gmail.com\n"
                + "Versão de Teste Inicial");
        // otherPanel.add(informationText);

        tFieldValorX = new TextField(18);
        tFieldValorY = new TextField(18);
        tFieldValorX.setText("10.0");
        tFieldValorY.setText("10.0");
        photoPanel.setNormalizerX(10.0);
        photoPanel.setNormalizerY(10.0);

        // otherPanel.add(tFieldValorX);
        // otherPanel.add(tFieldValorY);
        // otherPanel.add(loadNormalizers);
        reset = new JButton("Reset");
        reset.addActionListener(this);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1.setText("Valores em cm");
        jLabel2.setText("Resultados em cm");
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.setViewportView(informationText);
        resultButton = new javax.swing.JButton();
        resultButton.setText("Gerar resultados");
        resultButton.addActionListener(this);

        javax.swing.GroupLayout otherPanelLayout = new javax.swing.GroupLayout(otherPanel);
        otherPanel.setLayout(otherPanelLayout);
        otherPanelLayout.setHorizontalGroup(
                otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(otherPanelLayout.createSequentialGroup()
                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(otherPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(loadPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(37, 37, 37)
                                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(otherPanelLayout.createSequentialGroup()
                                                        .addComponent(tFieldValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(tFieldValorY, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(loadNormalizers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(otherPanelLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(otherPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(resultButton))
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(25, Short.MAX_VALUE))
        );
        otherPanelLayout.setVerticalGroup(
                otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, otherPanelLayout.createSequentialGroup()
                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(otherPanelLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tFieldValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tFieldValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, otherPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(loadPicture)
                                        .addGap(18, 18, 18)))
                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(loadNormalizers)
                                .addComponent(reset))
                        .addGroup(otherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(otherPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel2))
                                .addGroup(otherPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(resultButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addContainerGap())
        );

        frame.add(photoPanel);
        frame.add(otherPanel);
        frame.setLayout(new GridLayout(1, 2));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MedidorDeRaiz mr = new MedidorDeRaiz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadPicture) {
            int returnVal;
            returnVal = fileChooser.showOpenDialog(loadPicture);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile().toString());
                photoPanel.setFloorPlan(fileChooser.getSelectedFile());
                photoPanel.reset();
                informationText.setText("Medições reiniciadas"
                        + "\nProceda ao passo 1 novamente."
                        + "\n\n\n\n\nAutor: Vinícius Duarte Lopes"
                        + "\nEmail: vin.duartelopes@gmail.com\n"
                        + "Versão de Teste Inicial");
                tFieldValorX.setText("10.0");
                tFieldValorY.setText("10.0");
            }
        } else if (e.getSource() == loadNormalizers) {
            photoPanel.setNormalizerX(Double.parseDouble(tFieldValorX.getText()));
            photoPanel.setNormalizerY(Double.parseDouble(tFieldValorY.getText()));
            informationText.setText("Configurados X e Y\n"
                    + "X: " + photoPanel.getNormalizerX() + "\n"
                    + "Y: " + photoPanel.getNormalizerY() + "\n");
            /*
             + "PixX: " + photoPanel.getPixX() + "\n"
             + "PixY: " + photoPanel.getPixY() + "\n"
             + "PropX: " + photoPanel.getPropX() + "\n"
             + "PropY: " + photoPanel.getPropY() + "\n"
             + "Lista:\n" + photoPanel.printLineList() + "\n"
             + "Resultado:\n" + photoPanel.calculateInCentimeters())
             ;*/
        } else if (e.getSource() == reset) {
            photoPanel.reset();
            informationText.setText("Medições reiniciadas"
                    + "\nProceda ao passo 1 novamente."
                    + "\n\n\n\n\nAutor: Vinícius Duarte Lopes"
                    + "\nEmail: vin.duartelopes@gmail.com\n"
                    + "Versão de Teste Inicial");
            tFieldValorX.setText("10.0");
            tFieldValorY.setText("10.0");
        } else if (e.getSource() == resultButton) {
            if (!"".equals(photoPanel.calculateInCentimeters())) {
                informationText.setText(photoPanel.calculateInCentimeters());
            } else {
                informationText.setText("Não há resultados\npara serem mostrados.");
            }
        }
    }
}
