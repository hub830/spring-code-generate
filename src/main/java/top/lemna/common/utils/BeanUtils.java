package top.lemna.common.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtils {
  public static String[] getNullPropertyNames(Object source, String... ignoreProperties) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<String>();
    for (java.beans.PropertyDescriptor pd : pds) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null)
        emptyNames.add(pd.getName());
    }
    String[] result = new String[emptyNames.size()];
    result = emptyNames.toArray(result);
    if (ignoreProperties == null || ignoreProperties.length == 0) {
      return result;
    }
    result = Arrays.copyOf(result, emptyNames.size() + ignoreProperties.length);// 数组扩容
    System.arraycopy(ignoreProperties, 0, result, emptyNames.size(), ignoreProperties.length);

    return result;
  }

  public static void copyPropertiesIgnoreNull(Object source, Object target,
      String... ignoreProperties) {
    org.springframework.beans.BeanUtils.copyProperties(source, target,
        getNullPropertyNames(source, ignoreProperties));
  }
  
}
