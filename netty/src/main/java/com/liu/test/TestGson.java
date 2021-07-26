package com.liu.test;

import com.google.gson.*;

import java.lang.reflect.Type;

public class TestGson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassCodec()).create();
        System.out.println(gson.toJson(String.class));
//        System.out.println(new Gson().toJson(String.class));//有问题
    }

    static class ClassCodec implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>> {

        @Override
        public Class<?> deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                String str = json.getAsString();
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new JsonParseException(e);
            }
        }

        @Override
        public JsonElement serialize(Class<?> clazz, Type type, JsonSerializationContext jsonSerializationContext) {
            //class -> json
            return new JsonPrimitive(clazz.getName());
        }
    }
}
