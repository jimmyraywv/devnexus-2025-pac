package compliance.validators;

import com.styra.opa.OPAClient;
import com.styra.opa.OPAException;
import com.styra.opa.openapi.OpaApiClient;
import com.styra.opa.openapi.models.operations.ExecutePolicyWithInputRequest;
import com.styra.opa.openapi.models.operations.ExecutePolicyWithInputRequestBody;
import com.styra.opa.openapi.models.operations.ExecutePolicyWithInputResponse;
import com.styra.opa.openapi.models.shared.Input;
import com.styra.opa.wasm.OpaPolicy;
import compliance.utils.TextEnum;
import compliance.utils.Config;

import java.io.File;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/**
 * Opa validates JSON using SDK calls to OPA server
 *
 * @author jimmyray
 * @version 1.0
 */

public class Opa {

    /**
     * @param json       JSON string from class parser
     * @param map        JSON object map from class parser
     * @param policyPath OPA policy URL
     * @throws Exception Base exception
     */
    public static void validate(String json, Map<String, Object> map, String policyPath) throws Exception {
        OpaApiClient sdk = OpaApiClient.builder().build();

        ExecutePolicyWithInputRequest req = ExecutePolicyWithInputRequest.builder()
                .path(policyPath)
                .requestBody(ExecutePolicyWithInputRequestBody.builder()
                        .input(Input.of(map))
                        .build())
                .build();

        ExecutePolicyWithInputResponse res = sdk.executePolicyWithInput()
                .request(req)
                .call();

        if (res.successfulPolicyResponse().isPresent()) {
            System.out.println(res);
        }
    }

    /**
     * Calls OPA server to validate JSON
     *
     * @param map JSON object map from class parser
     * @param policyPath OPA policy URL
     * @return List<Map < String, Object>> result
     * @throws OPAException OPA exception
     */
    public static List<Map<String, Object>> validate(Map<String, Object> map, String policyPath) throws OPAException {
        Map<String, String> headers = Map.ofEntries(entry("Authorization", "Bearer " +
                Config.properties.getProperty(TextEnum.OPA_BEARER_TOKEN_KEY.getValue(), TextEnum.MSG_PROP_NOT_FOUND.getValue())));
        OPAClient opa = new OPAClient(Config.properties.getProperty(TextEnum.OPA_URL_KEY.getValue(), TextEnum.OPA_URL.getValue()), headers);

        return opa.evaluate(policyPath, map);
    }

    public static List<Map<String, Object>> validate(String json, String policyPath) throws OPAException {
        Map<String, String> headers = Map.ofEntries(entry("Authorization", "Bearer " +
                Config.properties.getProperty(TextEnum.OPA_BEARER_TOKEN_KEY.getValue(), TextEnum.MSG_PROP_NOT_FOUND.getValue())));
        OPAClient opa = new OPAClient(Config.properties.getProperty(TextEnum.OPA_URL_KEY.getValue(), TextEnum.OPA_URL.getValue()), headers);

        return opa.evaluate(policyPath, json);
    }

    public static List<Map<String, Object>> validate(Object json, String policyPath) throws OPAException {
        Map<String, String> headers = Map.ofEntries(entry("Authorization", "Bearer " +
                Config.properties.getProperty(TextEnum.OPA_BEARER_TOKEN_KEY.getValue(), TextEnum.MSG_PROP_NOT_FOUND.getValue())));
        OPAClient opa = new OPAClient(Config.properties.getProperty(TextEnum.OPA_URL_KEY.getValue(), TextEnum.OPA_URL.getValue()), headers);

        return opa.evaluate(policyPath, json);
    }

    public static String validateWasm(String input, String policyWasm) throws OPAException {
        var policy = OpaPolicy.builder().withPolicy(new File(policyWasm)).build();
        return policy.evaluate(input);
    }


}
