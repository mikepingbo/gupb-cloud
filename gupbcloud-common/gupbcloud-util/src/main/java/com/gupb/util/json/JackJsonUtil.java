package com.gupb.util.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JackJsonUtil {

    /**
     * 对象转json字符串
     * 
     * @param object
     * @return
     * @throws JsonProcessingException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @throws IOException
     */
    public static <T> String objectToJsonStr(T object) throws JsonProcessingException {
        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。 writeValue(File arg0, Object
         * arg1)把arg1转成json序列，并保存到arg0文件中。 writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。 writeValueAsString(Object
         * arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    /**
     * json字符串转对象
     * 
     * @param jsonStr
     * @param classOfT
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public static <T> T jsonStrToObject(String jsonStr, Class<T> classOfT) throws JsonParseException,
            JsonMappingException, IOException {
        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();

        // 设置JSON时间格式
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(myDateFormat);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonStr, classOfT);
    }

    public static ObjectNode objectToObjectNode(Object object) throws Exception {
        ObjectNode objectNode = jsonStrToObject(objectToJsonStr(object), ObjectNode.class);
        return objectNode;
    }

    /**
     * json字符串转对象-指定类型转换
     * 
     * @param str
     * @param type
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T fromJson(String str, TypeReference<T> type) throws JsonParseException, JsonMappingException,
        IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 设置JSON时间格式
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(myDateFormat);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(str, type);
    }
}
