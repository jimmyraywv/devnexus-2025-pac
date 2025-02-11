package compliance.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import compliance.parser.ParserReturn;

import java.util.Map;

/**
 * Static JSON utilities.
 *
 * @author jimmyray
 * @version 1.0
 */
public class JsonUtils {
    /**
     * Generate JSON Schema
     *
     * @param clazz Java class
     * @return String JSON schema
     */
    public static String getSchema(Class<?> clazz) {
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(clazz);

        return jsonSchema.toPrettyString();
    }

    /**
     * Get Map from JSON object
     *
     * @param Object
     * @return
     */
    public static Map<String, Object> getJsonMap(Object Object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        return mapper.convertValue(Object, new TypeReference<>() {
        });
    }

    /**
     * Get JSON string from object
     *
     * @param Object
     * @return
     * @throws Exception
     */
    public static String getJsonString(Object Object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        return mapper.writeValueAsString(Object);

    }

    /**
     * Create ParserReturn object
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static ParserReturn getJson(Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        Map<String, Object> map = mapper.convertValue(object, new TypeReference<>() {
        });

        return new ParserReturn(map, mapper.writeValueAsString(object));
    }

    /**
     * Create a JSON node from a string
     *
     * @param in
     * @return
     * @throws Exception
     */
    public static JsonNode getJsonNodeFromString(String in) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readTree(in);
    }

    /**
     * Get Map from JSON string
     *
     * @param in
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getMapFromJsonString(String in) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(JsonUtils.getJsonNodeFromString(in).get(0), Map.class);
        return map;
    }

    /**
     * Inject a map into a node tree
     *
     * @param map
     * @return
     */
    public static ObjectNode putMapInNode(Map<String, String> map) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        ObjectNode node = mapper.createObjectNode();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            node.put(entry.getKey(), entry.getValue());
        }

        return node;
    }

    /**
     * Add an Object to an existing node tree
     *
     * @param jsonNode
     * @param object
     * @param key
     * @return
     */
    public static JsonNode addObjectToTree(JsonNode jsonNode, Object object, String key) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        JsonNode node = mapper.valueToTree(object);
        ((ObjectNode) jsonNode).set("result", node);

        return jsonNode;
    }
}
