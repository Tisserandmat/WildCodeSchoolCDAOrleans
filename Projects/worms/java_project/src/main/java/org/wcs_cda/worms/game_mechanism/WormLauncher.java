package org.wcs_cda.worms.game_mechanism;

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;

import org.wcs_cda.worms.Config;

public class WormLauncher extends JFrame {
	private TimeController mainLoop;
	
    public WormLauncher() {
        initUI();
    }
    
    private void initUI() {
        mainLoop = new TimeController();
        
        add(mainLoop.getBoard());
               
        setResizable(false);
        pack();
        
        setTitle("WCS - CDA - Worms");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	try {
    		Config.loadConfig();
    	}
    	catch(Exception ex) {
    		System.err.println(
    			"Could not load configuration, please check ..."
    		);
    		System.err.println(ex.getMessage());
    		ex.printStackTrace();
    		System.exit(1);
    	}
    	
    	// --launch-test is an option for CI. No headless for the
    	// moment
    	if(Arrays.asList(args).contains("--launch-test")) {
    		System.out.println("Launching successfull !");
    		System.exit(0);
    	}
    	
        EventQueue.invokeLater(() -> {
            JFrame ex = new WormLauncher();
            ex.setVisible(true);
        });
    }
}