package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSearchable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSearchable.MoSearchableInterface.MoSearchableItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// search is done by multi-threading and merging the results
public class MoSearchableUtils {

    // we put 20 items in each thread to perform search async
    private static final int ITEMS_PER_SEARCH_THREAD = 20;
    private static final int NUMBER_OF_THREADS = 30;

    /**
     *
     * @param list indexes of where we have found a search for
     * @param criteria
     * @return
     */
    public static List<Integer> search(List<? extends MoSearchableItem> list, Object ... criteria){
        List<Integer> indexes = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for(int i = 0;i < list.size();i+=ITEMS_PER_SEARCH_THREAD){
            int finalI = i;
            executor.execute(()->search(finalI,finalI+ITEMS_PER_SEARCH_THREAD,indexes,list,criteria));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}
        return indexes;
    }


    /**
     * adds all the indexes of searchable
     * items from start to end (it is synchronized when adding)
     * @param start index of list
     * @param end index of list
     * @param indexes list of found indexes
     * @param list to be searched
     * @param criteria of search
     */
    private static void search(int start,int end,List<Integer> indexes,
                                        List<? extends MoSearchableItem> list, Object ... criteria){
        int actualEnd = Math.min(end,list.size());
        for(int i = start;i < actualEnd; i++){
            boolean b = list.get(i).updateSearchable(criteria);
            if(b){
                addToIndexes(i,indexes);
            }
        }
    }

    /**
     * synchronized way of adding an index to a shared list
     * @param index
     * @param indexes
     */
    private static synchronized void addToIndexes(int index,List<Integer> indexes){
        indexes.add(index);
    }



    public static void cancelSearch(List<? extends MoSearchableItem> list){
        if(list == null)
            return;

        for(MoSearchableItem item: list){
            item.setSearchable(false);
        }
    }

    public static List<? extends MoSearchableItem>
        getSearchableItems(List<? extends MoSearchableItem> list, List<Integer> indexes){
        if(list == null)
            return new ArrayList<>();

        List<MoSearchableItem> picked = new ArrayList<>();
        for(Integer i: indexes){
            picked.add(list.get(i));
        }
        return picked;
    }


    /**
     *
     *
     * @param listOf fields that we are checking
     * @return true if any of the items inside the [listOf]
     *         contains the search text
     *         returns false otherwise
     */
    public static boolean isSearchable(boolean whenEmptyOrNull, Object[] criteria,String ... listOf){
        if(criteria==null || criteria.length == 0){
            return whenEmptyOrNull;
        }
        String search = (String) criteria[0];
        if(search.isEmpty()){
            return whenEmptyOrNull;
        }
        String lowerCase = search.toLowerCase().trim();
        for(String item:listOf){
            if(item != null && item.toLowerCase().trim().contains(lowerCase)){
                return true;
            }
        }
        return false;
    }





}
