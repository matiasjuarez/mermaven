package matias.navigation.santander;

/**
 * Created by matias on 25/05/17.
 */
public class NavigationStatus {
    private boolean logged;
    private CURRENT_PAGE current_page;

    public enum CURRENT_PAGE {
        NONE,
        STARTING_PAGE,
        LOGIN_PAGE,
        CLIENTE_ACCOUNT_PAGE;
    }

    public NavigationStatus(){
        this.current_page = CURRENT_PAGE.NONE;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public CURRENT_PAGE getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(CURRENT_PAGE current_page) {
        this.current_page = current_page;
    }
}
