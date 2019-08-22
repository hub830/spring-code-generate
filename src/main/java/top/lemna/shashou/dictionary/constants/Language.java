package top.lemna.shashou.dictionary.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public enum Language {
  ZH("简体中文"), //
  EN("英文"), //
  ;//

  private String name;

  private Language(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Map<String, String> toMap() {
    return ImmutableMap.<String, String>builder()//
        .put("name", name)//
        .put("value", toString())//
        .build();
  }

  public static List<Map<String, String>> maps() {
    Language[] values = values();
    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    for (Language item : values) {
      list.add(item.toMap());
    }
    return list;
  }
}
