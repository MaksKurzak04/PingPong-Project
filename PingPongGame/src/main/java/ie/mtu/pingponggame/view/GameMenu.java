package ie.mtu.pingponggame.view;

import ie.mtu.pingponggame.controller.MenuListener;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import ie.mtu.pingponggame.controller.MainController;
import ie.mtu.pingponggame.model.Game;

public class GameMenu {
    private MenuBar menubar;
    private javafx.scene.control.Menu menuFile;
    private javafx.scene.control.Menu menuSettings;
    private javafx.scene.control.Menu menuHelp;

    private MenuItem menuItemExit;
    private MenuItem menuItemRestart;
    private MenuItem menuItemAbout;
    private MenuItem menuItemSpeed;
    private MenuItem menuItemRacketSize;
    private MenuItem menuItemScoreLimit;
    private MenuItem menuItemNames;
    private MenuListener menuListener;

    /**
     *
     * @param menuListener
     */
    public GameMenu(MenuListener menuListener) {
        this.menuListener = menuListener;
        this.menubar = new MenuBar();
        this.menuFile = new javafx.scene.control.Menu("File");
        this.menuSettings = new javafx.scene.control.Menu("Settings");
        this.menuHelp = new javafx.scene.control.Menu("Help");
        this.menuItemExit = new MenuItem("Quit");
        this.menuItemRestart = new MenuItem("Restart");
        this.menuItemAbout = new MenuItem("About");
        this.menuItemSpeed = new MenuItem("Speed");
        this.menuItemRacketSize = new MenuItem("Racket Size");
        this.menuItemScoreLimit = new MenuItem("Score Limit");
        this.menuItemNames = new MenuItem("Names");

        this.menuFile.getItems().add(this.menuItemExit);
        this.menuFile.getItems().add(this.menuItemRestart);
        this.menuSettings.getItems().add(this.menuItemNames);
        this.menuSettings.getItems().add(this.menuItemScoreLimit);
        this.menuSettings.getItems().add(this.menuItemSpeed);
        this.menuSettings.getItems().add(this.menuItemRacketSize);
        this.menuHelp.getItems().add(this.menuItemAbout);

        this.menubar.getMenus().addAll(new javafx.scene.control.Menu[]{this.menuFile, this.menuSettings, this.menuHelp});
        this.handleClicking();
    }

    private void handleClicking(){
        this.menuItemExit.setOnAction((e) -> {
            this.menuListener.setExit();
        });

        this.menuItemAbout.setOnAction((e) -> {
            this.menuListener.setAbout();
        });

        this.menuItemSpeed.setOnAction((e) -> {
            this.menuListener.setGameLimit();
        });

        this.menuItemRestart.setOnAction((e) -> {
            this.menuListener.restartGame();
        });

    }











    public void setMenuListener(MenuListener menuListener){
        this.menuListener=menuListener;
    }

    public MenuBar getMenubar() {
        return menubar;
    }

    public void setMenubar(MenuBar menubar) {
        this.menubar = menubar;
    }

    public MenuBar getMenuBar(){return this.menubar;}

    public Menu getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(Menu menuFile) {
        this.menuFile = menuFile;
    }

    public Menu getMenuSettings() {
        return menuSettings;
    }

    public void setMenuSettings(Menu menuSettings) {
        this.menuSettings = menuSettings;
    }

    public Menu getMenuHelp() {
        return menuHelp;
    }

    public void setMenuHelp(Menu menuHelp) {
        this.menuHelp = menuHelp;
    }

    public MenuItem getMenuItemExit() {
        return menuItemExit;
    }

    public void setMenuItemExit(MenuItem menuItemExit) {
        this.menuItemExit = menuItemExit;
    }

    public MenuItem getMenuItemAbout() {
        return menuItemAbout;
    }

    public void setMenuItemAbout(MenuItem menuItemAbout) {
        this.menuItemAbout = menuItemAbout;
    }

    public MenuItem getMenuItemSpeed() {
        return menuItemSpeed;
    }

    public void setMenuItemSpeed(MenuItem menuItemSpeed) {
        this.menuItemSpeed = menuItemSpeed;
    }

    public MenuItem getMenuItemRacketSize() {
        return menuItemRacketSize;
    }

    public void setMenuItemRacketSize(MenuItem menuItemRacketSize) {
        this.menuItemRacketSize = menuItemRacketSize;
    }

    public MenuItem getMenuItemScoreLimit() {
        return menuItemScoreLimit;
    }

    public void setMenuItemScoreLimit(MenuItem menuItemScoreLimit) {
        this.menuItemScoreLimit = menuItemScoreLimit;
    }

    public MenuItem getMenuItemNames() {
        return menuItemNames;
    }

    public void setMenuItemNames(MenuItem menuItemNames) {
        this.menuItemNames = menuItemNames;
    }

    public MenuListener getMenuListener() {
        return menuListener;
    }
}
