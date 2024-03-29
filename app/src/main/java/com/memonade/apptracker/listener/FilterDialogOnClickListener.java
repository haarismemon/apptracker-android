package com.memonade.apptracker.listener;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import com.memonade.apptracker.FilterDialogFragment;
import com.memonade.apptracker.model.FilterType;

import java.util.List;
import java.util.Map;

import static com.memonade.apptracker.MainActivity.CHECKED_ITEMS;
import static com.memonade.apptracker.MainActivity.FILTER_LIST;
import static com.memonade.apptracker.MainActivity.FILTER_TYPE;

/**
 * This class represents the On Click Listener for filter select text views to show the dialog.
 */

public class FilterDialogOnClickListener implements View.OnClickListener {

    private FragmentManager mFragmentManager;
    //list of all items of the filter type
    private List<String> itemsListForDialog;
    private Map<FilterType, List<Integer>> selectedItemsIndexesMap;
    private FilterType filterType;

    public FilterDialogOnClickListener(FragmentManager mFragmentManager,
                                       List<String> itemsListForDialog,
                                       Map<FilterType, List<Integer>> selectedItemsIndexesMap,
                                       FilterType filterType) {
        this.mFragmentManager = mFragmentManager;
        this.itemsListForDialog = itemsListForDialog;
        this.selectedItemsIndexesMap = selectedItemsIndexesMap;
        this.filterType = filterType;
    }

    @Override
    public void onClick(View view) {
        String[] itemsArray = itemsListForDialog.toArray(new String[itemsListForDialog.size()]);

        Bundle bundle = new Bundle();
        bundle.putStringArray(FILTER_LIST, itemsArray);
        bundle.putString(FILTER_TYPE, filterType.toString());

        List<Integer> selectedItemsIndexes = selectedItemsIndexesMap.get(filterType);

        //selectedItemsIndexes is null when nothing initially has been selected
        if(selectedItemsIndexes != null) {
            boolean[] checkedItems = new boolean[itemsListForDialog.size()];

            //converts the indexes into boolean array of all items with value true if index in list
            for (Integer selectedItemIndex : selectedItemsIndexes) {
                checkedItems[selectedItemIndex] = true;
            }

            bundle.putBooleanArray(CHECKED_ITEMS, checkedItems);
        }

        DialogFragment dialogFragment = new FilterDialogFragment();
        dialogFragment.setArguments(bundle);
        dialogFragment.show(mFragmentManager, "filterDialog");
    }
}