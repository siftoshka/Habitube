package az.siftoshka.habitube.presentation.explore.dialog.netflix;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NetflixDialogView extends MvpView {

}
