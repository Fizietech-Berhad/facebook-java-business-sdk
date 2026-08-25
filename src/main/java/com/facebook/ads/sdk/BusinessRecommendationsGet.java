/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class BusinessRecommendationsGet extends APINode {
  @SerializedName("data")
  private List<Object> mData = null;
  @SerializedName("paging")
  private Object mPaging = null;
  @SerializedName("summary")
  private Object mSummary = null;
  protected static Gson gson = null;

  public BusinessRecommendationsGet() {
  }

  public String getId() {
    return null;
  }
  public static BusinessRecommendationsGet loadJSON(String json, APIContext context, String header) {
    BusinessRecommendationsGet businessRecommendationsGet = getGson().fromJson(json, BusinessRecommendationsGet.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(businessRecommendationsGet.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      }
    }
    businessRecommendationsGet.context = context;
    businessRecommendationsGet.rawValue = json;
    businessRecommendationsGet.header = header;
    return businessRecommendationsGet;
  }

  public static APINodeList<BusinessRecommendationsGet> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<BusinessRecommendationsGet> businessRecommendationsGets = new APINodeList<BusinessRecommendationsGet>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          businessRecommendationsGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return businessRecommendationsGets;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                businessRecommendationsGets.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            businessRecommendationsGets.setPaging(previous, next);
            if (context.hasAppSecret()) {
              businessRecommendationsGets.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              businessRecommendationsGets.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  businessRecommendationsGets.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              businessRecommendationsGets.add(loadJSON(obj.toString(), context, header));
            }
          }
          return businessRecommendationsGets;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              businessRecommendationsGets.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return businessRecommendationsGets;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              businessRecommendationsGets.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return businessRecommendationsGets;
          }

          // Sixth, check if it's pure JsonObject
          businessRecommendationsGets.clear();
          businessRecommendationsGets.add(loadJSON(json, context, header));
          return businessRecommendationsGets;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public List<Object> getFieldData() {
    return mData;
  }

  public BusinessRecommendationsGet setFieldData(List<Object> value) {
    this.mData = value;
    return this;
  }

  public Object getFieldPaging() {
    return mPaging;
  }

  public BusinessRecommendationsGet setFieldPaging(Object value) {
    this.mPaging = value;
    return this;
  }

  public Object getFieldSummary() {
    return mSummary;
  }

  public BusinessRecommendationsGet setFieldSummary(Object value) {
    this.mSummary = value;
    return this;
  }



  public static enum EnumLocale {
      @SerializedName("AF_ZA")
      VALUE_AF_ZA("AF_ZA"),
      @SerializedName("AK_GH")
      VALUE_AK_GH("AK_GH"),
      @SerializedName("AM_ET")
      VALUE_AM_ET("AM_ET"),
      @SerializedName("AR_AR")
      VALUE_AR_AR("AR_AR"),
      @SerializedName("AS_IN")
      VALUE_AS_IN("AS_IN"),
      @SerializedName("AY_BO")
      VALUE_AY_BO("AY_BO"),
      @SerializedName("AZ_AZ")
      VALUE_AZ_AZ("AZ_AZ"),
      @SerializedName("BE_BY")
      VALUE_BE_BY("BE_BY"),
      @SerializedName("BG_BG")
      VALUE_BG_BG("BG_BG"),
      @SerializedName("BM_ML")
      VALUE_BM_ML("BM_ML"),
      @SerializedName("BN_IN")
      VALUE_BN_IN("BN_IN"),
      @SerializedName("BP_IN")
      VALUE_BP_IN("BP_IN"),
      @SerializedName("BR_FR")
      VALUE_BR_FR("BR_FR"),
      @SerializedName("BS_BA")
      VALUE_BS_BA("BS_BA"),
      @SerializedName("BV_DE")
      VALUE_BV_DE("BV_DE"),
      @SerializedName("CA_ES")
      VALUE_CA_ES("CA_ES"),
      @SerializedName("CB_IQ")
      VALUE_CB_IQ("CB_IQ"),
      @SerializedName("CK_US")
      VALUE_CK_US("CK_US"),
      @SerializedName("CO_FR")
      VALUE_CO_FR("CO_FR"),
      @SerializedName("CS_CZ")
      VALUE_CS_CZ("CS_CZ"),
      @SerializedName("CX_PH")
      VALUE_CX_PH("CX_PH"),
      @SerializedName("CY_GB")
      VALUE_CY_GB("CY_GB"),
      @SerializedName("DA_DK")
      VALUE_DA_DK("DA_DK"),
      @SerializedName("DE_DE")
      VALUE_DE_DE("DE_DE"),
      @SerializedName("EH_IN")
      VALUE_EH_IN("EH_IN"),
      @SerializedName("EL_GR")
      VALUE_EL_GR("EL_GR"),
      @SerializedName("EM_ZM")
      VALUE_EM_ZM("EM_ZM"),
      @SerializedName("EN_GB")
      VALUE_EN_GB("EN_GB"),
      @SerializedName("EN_IN")
      VALUE_EN_IN("EN_IN"),
      @SerializedName("EN_OP")
      VALUE_EN_OP("EN_OP"),
      @SerializedName("EN_PI")
      VALUE_EN_PI("EN_PI"),
      @SerializedName("EN_UD")
      VALUE_EN_UD("EN_UD"),
      @SerializedName("EN_US")
      VALUE_EN_US("EN_US"),
      @SerializedName("EN_XA")
      VALUE_EN_XA("EN_XA"),
      @SerializedName("EO_EO")
      VALUE_EO_EO("EO_EO"),
      @SerializedName("ES_CL")
      VALUE_ES_CL("ES_CL"),
      @SerializedName("ES_CO")
      VALUE_ES_CO("ES_CO"),
      @SerializedName("ES_ES")
      VALUE_ES_ES("ES_ES"),
      @SerializedName("ES_LA")
      VALUE_ES_LA("ES_LA"),
      @SerializedName("ES_MX")
      VALUE_ES_MX("ES_MX"),
      @SerializedName("ES_VE")
      VALUE_ES_VE("ES_VE"),
      @SerializedName("ET_EE")
      VALUE_ET_EE("ET_EE"),
      @SerializedName("EU_ES")
      VALUE_EU_ES("EU_ES"),
      @SerializedName("FA_IR")
      VALUE_FA_IR("FA_IR"),
      @SerializedName("FBT_AC")
      VALUE_FBT_AC("FBT_AC"),
      @SerializedName("FB_AA")
      VALUE_FB_AA("FB_AA"),
      @SerializedName("FB_AC")
      VALUE_FB_AC("FB_AC"),
      @SerializedName("FB_AR")
      VALUE_FB_AR("FB_AR"),
      @SerializedName("FB_HA")
      VALUE_FB_HA("FB_HA"),
      @SerializedName("FB_HX")
      VALUE_FB_HX("FB_HX"),
      @SerializedName("FB_LL")
      VALUE_FB_LL("FB_LL"),
      @SerializedName("FB_LS")
      VALUE_FB_LS("FB_LS"),
      @SerializedName("FB_LT")
      VALUE_FB_LT("FB_LT"),
      @SerializedName("FB_RL")
      VALUE_FB_RL("FB_RL"),
      @SerializedName("FB_ZH")
      VALUE_FB_ZH("FB_ZH"),
      @SerializedName("FF_NG")
      VALUE_FF_NG("FF_NG"),
      @SerializedName("FI_FI")
      VALUE_FI_FI("FI_FI"),
      @SerializedName("FN_IT")
      VALUE_FN_IT("FN_IT"),
      @SerializedName("FO_FO")
      VALUE_FO_FO("FO_FO"),
      @SerializedName("FR_CA")
      VALUE_FR_CA("FR_CA"),
      @SerializedName("FR_FR")
      VALUE_FR_FR("FR_FR"),
      @SerializedName("FV_NG")
      VALUE_FV_NG("FV_NG"),
      @SerializedName("FY_NL")
      VALUE_FY_NL("FY_NL"),
      @SerializedName("GA_IE")
      VALUE_GA_IE("GA_IE"),
      @SerializedName("GL_ES")
      VALUE_GL_ES("GL_ES"),
      @SerializedName("GN_PY")
      VALUE_GN_PY("GN_PY"),
      @SerializedName("GU_IN")
      VALUE_GU_IN("GU_IN"),
      @SerializedName("GX_GR")
      VALUE_GX_GR("GX_GR"),
      @SerializedName("HA_NG")
      VALUE_HA_NG("HA_NG"),
      @SerializedName("HE_IL")
      VALUE_HE_IL("HE_IL"),
      @SerializedName("HI_FB")
      VALUE_HI_FB("HI_FB"),
      @SerializedName("HI_IN")
      VALUE_HI_IN("HI_IN"),
      @SerializedName("HR_HR")
      VALUE_HR_HR("HR_HR"),
      @SerializedName("HT_HT")
      VALUE_HT_HT("HT_HT"),
      @SerializedName("HU_HU")
      VALUE_HU_HU("HU_HU"),
      @SerializedName("HY_AM")
      VALUE_HY_AM("HY_AM"),
      @SerializedName("ID_ID")
      VALUE_ID_ID("ID_ID"),
      @SerializedName("IG_NG")
      VALUE_IG_NG("IG_NG"),
      @SerializedName("IK_US")
      VALUE_IK_US("IK_US"),
      @SerializedName("IS_IS")
      VALUE_IS_IS("IS_IS"),
      @SerializedName("IT_IT")
      VALUE_IT_IT("IT_IT"),
      @SerializedName("IU_CA")
      VALUE_IU_CA("IU_CA"),
      @SerializedName("JA_JP")
      VALUE_JA_JP("JA_JP"),
      @SerializedName("JA_KS")
      VALUE_JA_KS("JA_KS"),
      @SerializedName("JV_ID")
      VALUE_JV_ID("JV_ID"),
      @SerializedName("KA_GE")
      VALUE_KA_GE("KA_GE"),
      @SerializedName("KK_KZ")
      VALUE_KK_KZ("KK_KZ"),
      @SerializedName("KM_KH")
      VALUE_KM_KH("KM_KH"),
      @SerializedName("KN_IN")
      VALUE_KN_IN("KN_IN"),
      @SerializedName("KO_KR")
      VALUE_KO_KR("KO_KR"),
      @SerializedName("KS_IN")
      VALUE_KS_IN("KS_IN"),
      @SerializedName("KU_TR")
      VALUE_KU_TR("KU_TR"),
      @SerializedName("KY_KG")
      VALUE_KY_KG("KY_KG"),
      @SerializedName("LA_VA")
      VALUE_LA_VA("LA_VA"),
      @SerializedName("LG_UG")
      VALUE_LG_UG("LG_UG"),
      @SerializedName("LI_NL")
      VALUE_LI_NL("LI_NL"),
      @SerializedName("LN_CD")
      VALUE_LN_CD("LN_CD"),
      @SerializedName("LO_LA")
      VALUE_LO_LA("LO_LA"),
      @SerializedName("LR_IT")
      VALUE_LR_IT("LR_IT"),
      @SerializedName("LT_LT")
      VALUE_LT_LT("LT_LT"),
      @SerializedName("LV_LV")
      VALUE_LV_LV("LV_LV"),
      @SerializedName("MG_MG")
      VALUE_MG_MG("MG_MG"),
      @SerializedName("MI_NZ")
      VALUE_MI_NZ("MI_NZ"),
      @SerializedName("MK_MK")
      VALUE_MK_MK("MK_MK"),
      @SerializedName("ML_IN")
      VALUE_ML_IN("ML_IN"),
      @SerializedName("MN_MN")
      VALUE_MN_MN("MN_MN"),
      @SerializedName("MOS_BF")
      VALUE_MOS_BF("MOS_BF"),
      @SerializedName("MR_IN")
      VALUE_MR_IN("MR_IN"),
      @SerializedName("MS_MY")
      VALUE_MS_MY("MS_MY"),
      @SerializedName("MT_MT")
      VALUE_MT_MT("MT_MT"),
      @SerializedName("MY_MM")
      VALUE_MY_MM("MY_MM"),
      @SerializedName("NB_NO")
      VALUE_NB_NO("NB_NO"),
      @SerializedName("ND_ZW")
      VALUE_ND_ZW("ND_ZW"),
      @SerializedName("NE_NP")
      VALUE_NE_NP("NE_NP"),
      @SerializedName("NH_MX")
      VALUE_NH_MX("NH_MX"),
      @SerializedName("NL_BE")
      VALUE_NL_BE("NL_BE"),
      @SerializedName("NL_NL")
      VALUE_NL_NL("NL_NL"),
      @SerializedName("NN_NO")
      VALUE_NN_NO("NN_NO"),
      @SerializedName("NR_ZA")
      VALUE_NR_ZA("NR_ZA"),
      @SerializedName("NS_ZA")
      VALUE_NS_ZA("NS_ZA"),
      @SerializedName("NY_MW")
      VALUE_NY_MW("NY_MW"),
      @SerializedName("OM_ET")
      VALUE_OM_ET("OM_ET"),
      @SerializedName("OR_IN")
      VALUE_OR_IN("OR_IN"),
      @SerializedName("PA_IN")
      VALUE_PA_IN("PA_IN"),
      @SerializedName("PCM_NG")
      VALUE_PCM_NG("PCM_NG"),
      @SerializedName("PL_PL")
      VALUE_PL_PL("PL_PL"),
      @SerializedName("PS_AF")
      VALUE_PS_AF("PS_AF"),
      @SerializedName("PT_BR")
      VALUE_PT_BR("PT_BR"),
      @SerializedName("PT_PT")
      VALUE_PT_PT("PT_PT"),
      @SerializedName("QB_DE")
      VALUE_QB_DE("QB_DE"),
      @SerializedName("QC_GT")
      VALUE_QC_GT("QC_GT"),
      @SerializedName("QE_US")
      VALUE_QE_US("QE_US"),
      @SerializedName("QK_DZ")
      VALUE_QK_DZ("QK_DZ"),
      @SerializedName("QR_GR")
      VALUE_QR_GR("QR_GR"),
      @SerializedName("QS_DE")
      VALUE_QS_DE("QS_DE"),
      @SerializedName("QT_US")
      VALUE_QT_US("QT_US"),
      @SerializedName("QU_PE")
      VALUE_QU_PE("QU_PE"),
      @SerializedName("QV_IT")
      VALUE_QV_IT("QV_IT"),
      @SerializedName("QZ_MM")
      VALUE_QZ_MM("QZ_MM"),
      @SerializedName("RM_CH")
      VALUE_RM_CH("RM_CH"),
      @SerializedName("RN_BI")
      VALUE_RN_BI("RN_BI"),
      @SerializedName("RO_RO")
      VALUE_RO_RO("RO_RO"),
      @SerializedName("RU_RU")
      VALUE_RU_RU("RU_RU"),
      @SerializedName("RW_RW")
      VALUE_RW_RW("RW_RW"),
      @SerializedName("SA_IN")
      VALUE_SA_IN("SA_IN"),
      @SerializedName("SC_IT")
      VALUE_SC_IT("SC_IT"),
      @SerializedName("SE_NO")
      VALUE_SE_NO("SE_NO"),
      @SerializedName("SI_LK")
      VALUE_SI_LK("SI_LK"),
      @SerializedName("SK_SK")
      VALUE_SK_SK("SK_SK"),
      @SerializedName("SL_SI")
      VALUE_SL_SI("SL_SI"),
      @SerializedName("SN_ZW")
      VALUE_SN_ZW("SN_ZW"),
      @SerializedName("SO_SO")
      VALUE_SO_SO("SO_SO"),
      @SerializedName("SQ_AL")
      VALUE_SQ_AL("SQ_AL"),
      @SerializedName("SR_RS")
      VALUE_SR_RS("SR_RS"),
      @SerializedName("SS_SZ")
      VALUE_SS_SZ("SS_SZ"),
      @SerializedName("ST_ZA")
      VALUE_ST_ZA("ST_ZA"),
      @SerializedName("SU_ID")
      VALUE_SU_ID("SU_ID"),
      @SerializedName("SV_SE")
      VALUE_SV_SE("SV_SE"),
      @SerializedName("SW_KE")
      VALUE_SW_KE("SW_KE"),
      @SerializedName("SY_SY")
      VALUE_SY_SY("SY_SY"),
      @SerializedName("SZ_PL")
      VALUE_SZ_PL("SZ_PL"),
      @SerializedName("TA_IN")
      VALUE_TA_IN("TA_IN"),
      @SerializedName("TE_IN")
      VALUE_TE_IN("TE_IN"),
      @SerializedName("TG_TJ")
      VALUE_TG_TJ("TG_TJ"),
      @SerializedName("TH_TH")
      VALUE_TH_TH("TH_TH"),
      @SerializedName("TI_ET")
      VALUE_TI_ET("TI_ET"),
      @SerializedName("TK_TM")
      VALUE_TK_TM("TK_TM"),
      @SerializedName("TL_PH")
      VALUE_TL_PH("TL_PH"),
      @SerializedName("TL_ST")
      VALUE_TL_ST("TL_ST"),
      @SerializedName("TN_BW")
      VALUE_TN_BW("TN_BW"),
      @SerializedName("TPI_PG")
      VALUE_TPI_PG("TPI_PG"),
      @SerializedName("TQ_AR")
      VALUE_TQ_AR("TQ_AR"),
      @SerializedName("TR_TR")
      VALUE_TR_TR("TR_TR"),
      @SerializedName("TS_ZA")
      VALUE_TS_ZA("TS_ZA"),
      @SerializedName("TT_RU")
      VALUE_TT_RU("TT_RU"),
      @SerializedName("TZ_MA")
      VALUE_TZ_MA("TZ_MA"),
      @SerializedName("UK_UA")
      VALUE_UK_UA("UK_UA"),
      @SerializedName("UR_PK")
      VALUE_UR_PK("UR_PK"),
      @SerializedName("UZ_UZ")
      VALUE_UZ_UZ("UZ_UZ"),
      @SerializedName("VE_ZA")
      VALUE_VE_ZA("VE_ZA"),
      @SerializedName("VI_VN")
      VALUE_VI_VN("VI_VN"),
      @SerializedName("WO_SN")
      VALUE_WO_SN("WO_SN"),
      @SerializedName("XH_ZA")
      VALUE_XH_ZA("XH_ZA"),
      @SerializedName("YI_DE")
      VALUE_YI_DE("YI_DE"),
      @SerializedName("YO_NG")
      VALUE_YO_NG("YO_NG"),
      @SerializedName("ZH_CN")
      VALUE_ZH_CN("ZH_CN"),
      @SerializedName("ZH_HK")
      VALUE_ZH_HK("ZH_HK"),
      @SerializedName("ZH_TW")
      VALUE_ZH_TW("ZH_TW"),
      @SerializedName("ZU_ZA")
      VALUE_ZU_ZA("ZU_ZA"),
      @SerializedName("ZZ_TR")
      VALUE_ZZ_TR("ZZ_TR"),
      ;

      private String value;

      private EnumLocale(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumScopes {
      @SerializedName("OWNED")
      VALUE_OWNED("OWNED"),
      @SerializedName("SHARED")
      VALUE_SHARED("SHARED"),
      ;

      private String value;

      private EnumScopes(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public BusinessRecommendationsGet copyFrom(BusinessRecommendationsGet instance) {
    this.mData = instance.mData;
    this.mPaging = instance.mPaging;
    this.mSummary = instance.mSummary;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<BusinessRecommendationsGet> getParser() {
    return new APIRequest.ResponseParser<BusinessRecommendationsGet>() {
      public APINodeList<BusinessRecommendationsGet> parseResponse(String response, APIContext context, APIRequest<BusinessRecommendationsGet> request, String header) throws MalformedResponseException {
        return BusinessRecommendationsGet.parseResponse(response, context, request, header);
      }
    };
  }
}
