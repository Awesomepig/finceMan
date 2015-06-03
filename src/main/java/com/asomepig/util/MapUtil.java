/**
 * Created by eric on 15-5-15.
 */
package com.asomepig.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapUtil {
    public static synchronized Map<String, String> getParameterMap(Map<String, String[]> parMap) {
        Map<String, String> map=new HashMap<String, String>();
        Iterator<Map.Entry<String, String[]>> it = parMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = it.next();
            String key = entry.getKey();// map中的key
            String[] value = entry.getValue();// 上面key对应的value
            map.put(key, StringUtil.stringFilter(value[0]));
        }
        return map;
    }
    /**
     * 将list转换成json
     * @param name json 定义名称
     * @param listMap jdbc获得的 listmap集合
     * @return
     */
    public static String listMapToJson(String name,List<Map<String, Object>> listMap){
        String json="";
        for (Map<String, Object> map : listMap) {
            json+="{";
            Iterator<Map.Entry<String, Object>> it=map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                json+="\""+entry.getKey()+"\":\""+StringUtil.stringJson(entry.getValue()==null?"":entry.getValue().toString())+"\",";
            }
            json = json.substring(0, json.length() - 1);
            json+="},";
        }
        if(json.length()>0)
            json=json.substring(0,json.length()-1);
        json = "[" + json + "]";
        return "\""+name+"\":"+json+"";
    }

    public static String mapToJson(Map<String,Object> map){
        if(map==null)
            return "";
        String json="{";
        Iterator<Map.Entry<String, Object>> it=map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            json+="\""+entry.getKey()+"\":\""+StringUtil.stringJson(entry.getValue())+"\",";
        }
        if(json.length()>0)
            json=json.substring(0,json.length()-1);
        json+="}";
        return json;
    }

}
