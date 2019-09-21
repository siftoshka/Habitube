package az.siftoshka.habitube;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import javax.inject.Inject;

import az.siftoshka.habitube.model.system.KeyboardBehavior;
import az.siftoshka.habitube.model.system.MessageListener;
import az.siftoshka.habitube.ui.movie.MovieFragment;
import az.siftoshka.habitube.ui.navbar.NavbarFragment;
import az.siftoshka.habitube.ui.search.SearchFragment;
import az.siftoshka.habitube.ui.show.ShowFragment;
import moxy.MvpAppCompatActivity;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import toothpick.Toothpick;

import static az.siftoshka.habitube.Constants.DI.APP_SCOPE;

public class MainActivity extends MvpAppCompatActivity implements MessageListener, KeyboardBehavior {

    @Inject NavigatorHolder navigatorHolder;
    @Inject Router router;

    private Navigator navigator = new SupportAppNavigator(this, R.id.fragment_container) {
        @Override
        protected void setupFragmentTransaction(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
            if (command instanceof Forward) {
                if (currentFragment instanceof NavbarFragment && nextFragment instanceof MovieFragment) {
                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                }
                if (currentFragment instanceof NavbarFragment && nextFragment instanceof ShowFragment) {
                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                }
                if (currentFragment instanceof MovieFragment && nextFragment instanceof MovieFragment) {
                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                }
                if (currentFragment instanceof ShowFragment && nextFragment instanceof ShowFragment) {
                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                }
                if (currentFragment instanceof SearchFragment && nextFragment instanceof MovieFragment) {
                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toothpick.inject(this, Toothpick.openScope(APP_SCOPE));
        router.newRootScreen(new Screens.NavbarScreen());
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    public void showInternetError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    @Override
    public void hideKeyboard() {
        final View view = findViewById(R.id.fragment_container);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

}