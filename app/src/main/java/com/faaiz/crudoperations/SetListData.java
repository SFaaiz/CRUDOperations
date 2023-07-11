package com.faaiz.crudoperations;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class SetListData extends Application {
    private static List<DataModel> list = new ArrayList<>();

    public SetListData() {
        setData();
    }

    public static List<DataModel> getList() {
        return list;
    }

    public static void setList(List<DataModel> list) {
        SetListData.list = list;
    }

    public void setData(){
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Rohit_Sharma_during_the_India_vs_Australia_4th_Test_match_at_Narendra_Modi_Stadium.jpg/330px-Rohit_Sharma_during_the_India_vs_Australia_4th_Test_match_at_Narendra_Modi_Stadium.jpg", "Rohit Sharma"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/5/5b/Hardik_Pandya_%28cropped%29.jpg", "Hardik Pandya"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/9/96/Ajinkya_Rahane_2016_%28cropped%29.jpg", "Ajinkya Rahane"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/9/96/Shreyas_Iyer_2021.jpg", "Shreyas Iyer"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Virat_Kohli_during_the_India_vs_Aus_4th_Test_match_at_Narendra_Modi_Stadium_on_09_March_2023.jpg/330px-Virat_Kohli_during_the_India_vs_Aus_4th_Test_match_at_Narendra_Modi_Stadium_on_09_March_2023.jpg", "Virat Kohli"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Shubman_Gill.jpg/330px-Shubman_Gill.jpg", "Shubman Gill"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Suryakumar.jpg/330px-Suryakumar.jpg", "Suryakumar Yadav"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Ravindra_Jadeja_in_2018.jpg/330px-Ravindra_Jadeja_in_2018.jpg", "Ravindra Jadeja"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/3/3c/Ravichandran_Ashwin_%28cropped%29.jpg", "Ravichandran Ashwin"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/0/08/K.L._Rahul_%281%29.jpg", "K. L. Rahul"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Jasprit_Bumrah_%284%29.jpg/330px-Jasprit_Bumrah_%284%29.jpg", "Jasprit Bumrah"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Indian_Cricket_team_training_SCG_2015_%2816007161637%29.jpg/330px-Indian_Cricket_team_training_SCG_2015_%2816007161637%29.jpg", "Mohammed Shami"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Mohammed_Siraj.jpg/330px-Mohammed_Siraj.jpg", "Mohammed Siraj"));
        list.add(new DataModel("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Deepak_Chahar.jpg/330px-Deepak_Chahar.jpg", "Deepak Chahar"));
    }

}
