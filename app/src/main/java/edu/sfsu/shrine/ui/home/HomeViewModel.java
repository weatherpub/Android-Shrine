package edu.sfsu.shrine.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.sfsu.shrine.code.model.RandomUserModel;
public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    /*
    private final MutableLiveData<RandomUserModel> uiState;

    public HomeViewModel(MutableLiveData<RandomUserModel> randomUserModelMutableLiveData) {

        uiState = new MutableLiveData<>(new RandomUserModel(
                "a",
                "b",
                "c",
                0,
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                0,
                "m",
                "n",
                "o",
                "p",
                "q",
                "r",
                "s",
                "t",
                "u",
                "v",
                "w",
                "x",
                "y",
                "z",
                "aa",
                0,
                "bb",
                "cc",
                "dd"
        ));
    }

    public LiveData<RandomUserModel> getState() {
        return uiState;
    }
     */
}