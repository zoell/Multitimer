package de.softinva.multitimer.fragments.dialogimportdataresult;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import java.util.LinkedList;

import de.softinva.multitimer.classes.abstract_classes.AppViewModel;
import de.softinva.multitimer.utility.UtilityMethods;

public class ImportDataResultDialogViewModel extends AppViewModel {
    private MutableLiveData<ImportDataMessages> importDataMessages$;

    public ImportDataResultDialogViewModel(Application application, SavedStateHandle savedStateHandle) {
        super(application, savedStateHandle);
    }

    public MutableLiveData<ImportDataMessages> getImportDataMessages() {
        if (importDataMessages$ == null) {
            importDataMessages$ = state.getLiveData("importDataMessages");
        }
        return importDataMessages$;
    }
}
