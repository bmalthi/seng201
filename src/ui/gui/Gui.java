package ui.gui;

import java.awt.EventQueue;

import main.IslandTrader;
import ui.IslandTraderUI;

/**
 * A graphical user interface for a {@link RocketManager}.
 */
public class Gui implements IslandTraderUI {

    // The rocket manager this gui interacts with
	private IslandTrader islandTrader;

    // The currently active screen in this gui
    //private Screen screen;

    @Override
    public void setup(IslandTrader islandTrader) {
        this.islandTrader = islandTrader;
        
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				SetupScreen window = new SetupScreen(islandTrader);
    				window.show();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
   }

    
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	
	}
	public static void main(String[] args) {
		IslandTrader islandTrader = new IslandTrader();
		islandTrader.launchSetupScreen();
	}
	
//    @Override
//    public void showError(String error) {
//        //screen.showError(error);
//    }
//
//    public void launchMainScreen() {
//    	MainScreen mainWindow = new MainScreen(this);
//    }
//    
//    
//    @Override
//    public void start() {
//        //screen.quit();
//        //screen = new MainScreen(rocketManager);
//        //screen.show();
//    }
//
//    //@Override
//    //public boolean confirmQuit() {
//    //    //return screen.confirmQuit();
//    //}
//
//    @Override
//    public void quit() {
//        //screen.quit();
//    }
}