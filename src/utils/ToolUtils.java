package utils;

import java.util.List;
import java.util.Objects;

/**
 * Created by 大灯泡 on 2018/10/11.
 */
public class ToolUtils {
    public static boolean isEmpty(List<?> which) {
        return which == null || which.size() <= 0;
    }

    public static boolean isEmpty(Object... obj) {
        return obj == null || obj.length <= 0;
    }
}
