package fr.wildcodeschool.storage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Storage {

  private SharedPreferences sharedPreferences;
  private static final String PREFS = "PREFS";
  private static final String PREFS_INT_LIST = "PREFS_INT_LIST";

  public Storage(Context context){
    sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
  }

  protected String transformToString(List<Integer> list) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Integer i: list) stringBuilder.append(i+',');
    return stringBuilder.toString();
  }

  protected List<Integer> transformFromString(String string) {
    List<Integer> list = new ArrayList<>();
    for (String str: string.split(",")) list.add(Integer.valueOf(str));
    return list;
  }

  public List<Integer> load() {
    String content = sharedPreferences.getString(PREFS_INT_LIST, null);
    if (null != content)
      return transformFromString(content);
    else
      return new ArrayList<>();
  }

  public void save(List<Integer> list) {
    sharedPreferences
      .edit()
      .putString(PREFS_INT_LIST, transformToString(list))
      .apply();
  }
}
