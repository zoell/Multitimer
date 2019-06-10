package de.softinva.multitimer.fragments.dialogeditcooldown;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProvider;

import de.softinva.multitimer.R;
import de.softinva.multitimer.classes.abstract_classes.AppDialogFragmentDataBinding;
import de.softinva.multitimer.classes.abstract_classes.AppViewObject;
import de.softinva.multitimer.databinding.EditDurationDialogBinding;
import de.softinva.multitimer.utility.EditDuration;

public class EditCoolDownDialog extends AppDialogFragmentDataBinding<EditCoolDownDialogViewModel> implements EditDuration.EditDurationActionsListener, EditDuration.UpdateDurationInSecListener {
    EditDuration editDuration;
    public MutableLiveData<Integer> coolDownInSec = new MutableLiveData<>();
    private UpdateCollDownInSecListener callbackCoolDownInSec;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        editDuration = new EditDuration(this, true);
        coolDownInSec.observe(this, durationInSec -> this.editDuration.durationInSec.setValue(durationInSec));
        setCallBackListener();
        return dialog;
    }

    private void setCallBackListener() {
        if (getContext() instanceof UpdateCollDownInSecListener) {
            callbackCoolDownInSec = (UpdateCollDownInSecListener) getContext();
        } else {
            throw new RuntimeException(getContext().toString()
                    + " must implement UpdateCollDownInSecListener");
        }
    }

    public interface UpdateCollDownInSecListener {
        void updateCoolDownInSec(int durationInSec);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding.unbind();
        editDuration.setCallbackToNull();
    }


    @Override
    protected void setClassSpecificObjects() {

    }

    public void setCoolDownInSec(int durationInSec) {
        this.coolDownInSec.setValue(durationInSec);
    }

    @Override
    protected AppViewObject setViewObject() {
        return null;
    }

    @Override
    protected EditCoolDownDialogViewModel setModel() {
        return new ViewModelProvider(this, new SavedStateVMFactory(this))
                .get(EditCoolDownDialogViewModel.class);
    }

    @Override
    protected ViewDataBinding setBinding() {
        EditDurationDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.edit_duration_dialog, null, false);
        return binding;
    }


    @Override
    public void onCancel() {
        dismiss();
    }

    @Override
    public void onSave() {
        dismiss();
    }

    @Override
    public void updateDurationInSec(int durationInSec) {
        callbackCoolDownInSec.updateCoolDownInSec(durationInSec);
    }
}