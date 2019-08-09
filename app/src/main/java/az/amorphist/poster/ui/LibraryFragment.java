package az.amorphist.poster.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import az.amorphist.poster.R;
import az.amorphist.poster.adapters.LibraryPagerAdapter;
import az.amorphist.poster.presentation.library.LibraryPresenter;
import az.amorphist.poster.presentation.library.LibraryView;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import toothpick.Toothpick;

import static az.amorphist.poster.Constants.DI.APP_SCOPE;

public class LibraryFragment extends MvpAppCompatFragment implements LibraryView, Toolbar.OnMenuItemClickListener {

    @InjectPresenter LibraryPresenter libraryPresenter;

    @Inject Context context;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @ProvidePresenter
    LibraryPresenter libraryPresenter() {
        return Toothpick.openScope(APP_SCOPE).getInstance(LibraryPresenter.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toothpick.inject(this, Toothpick.openScope(APP_SCOPE));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_library, container, false);
        toolbar = view.findViewById(R.id.library_toolbar);
        tabLayout = view.findViewById(R.id.library_tab);
        viewPager = view.findViewById(R.id.library_pager);
        FragmentPagerAdapter pagerAdapter = new LibraryPagerAdapter(context, getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.search_movies) {
            libraryPresenter.goToSearchScreen();
        }
        return false;
    }
}