package com.wxg.daily.translate.tencent.v20180321.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wxg.daily.translate.tencent.common.AbstractModel;

import java.util.HashMap;

public class SpeechTranslateResponse  extends AbstractModel {


    /**
    * 请求的SessionUuid直接返回
    */
    @SerializedName("SessionUuid")
    @Expose
    private String SessionUuid;

    /**
    * 语音识别状态 1-进行中 0-完成
    */
    @SerializedName("RecognizeStatus")
    @Expose
    private Integer RecognizeStatus;

    /**
    * 识别出的源文
    */
    @SerializedName("SourceText")
    @Expose
    private String SourceText;

    /**
    * 翻译出的译文
    */
    @SerializedName("TargetText")
    @Expose
    private String TargetText;

    /**
    * 第几个语音分片
    */
    @SerializedName("Seq")
    @Expose
    private Integer Seq;

    /**
    * 源语言
    */
    @SerializedName("Source")
    @Expose
    private String Source;

    /**
    * 目标语言
    */
    @SerializedName("Target")
    @Expose
    private String Target;

    /**
    * 唯一请求ID，每次请求都会返回。定位问题时需要提供该次请求的RequestId。
    */
    @SerializedName("RequestId")
    @Expose
    private String RequestId;

    /**
     * 获取请求的SessionUuid直接返回
     * @return SessionUuid 请求的SessionUuid直接返回
     */
    public String getSessionUuid() {
        return this.SessionUuid;
    }

    /**
     * 设置请求的SessionUuid直接返回
     * @param SessionUuid 请求的SessionUuid直接返回
     */
    public void setSessionUuid(String SessionUuid) {
        this.SessionUuid = SessionUuid;
    }

    /**
     * 获取语音识别状态 1-进行中 0-完成
     * @return RecognizeStatus 语音识别状态 1-进行中 0-完成
     */
    public Integer getRecognizeStatus() {
        return this.RecognizeStatus;
    }

    /**
     * 设置语音识别状态 1-进行中 0-完成
     * @param RecognizeStatus 语音识别状态 1-进行中 0-完成
     */
    public void setRecognizeStatus(Integer RecognizeStatus) {
        this.RecognizeStatus = RecognizeStatus;
    }

    /**
     * 获取识别出的源文
     * @return SourceText 识别出的源文
     */
    public String getSourceText() {
        return this.SourceText;
    }

    /**
     * 设置识别出的源文
     * @param SourceText 识别出的源文
     */
    public void setSourceText(String SourceText) {
        this.SourceText = SourceText;
    }

    /**
     * 获取翻译出的译文
     * @return TargetText 翻译出的译文
     */
    public String getTargetText() {
        return this.TargetText;
    }

    /**
     * 设置翻译出的译文
     * @param TargetText 翻译出的译文
     */
    public void setTargetText(String TargetText) {
        this.TargetText = TargetText;
    }

    /**
     * 获取第几个语音分片
     * @return Seq 第几个语音分片
     */
    public Integer getSeq() {
        return this.Seq;
    }

    /**
     * 设置第几个语音分片
     * @param Seq 第几个语音分片
     */
    public void setSeq(Integer Seq) {
        this.Seq = Seq;
    }

    /**
     * 获取源语言
     * @return Source 源语言
     */
    public String getSource() {
        return this.Source;
    }

    /**
     * 设置源语言
     * @param Source 源语言
     */
    public void setSource(String Source) {
        this.Source = Source;
    }

    /**
     * 获取目标语言
     * @return Target 目标语言
     */
    public String getTarget() {
        return this.Target;
    }

    /**
     * 设置目标语言
     * @param Target 目标语言
     */
    public void setTarget(String Target) {
        this.Target = Target;
    }

    /**
     * 获取唯一请求ID，每次请求都会返回。定位问题时需要提供该次请求的RequestId。
     * @return RequestId 唯一请求ID，每次请求都会返回。定位问题时需要提供该次请求的RequestId。
     */
    public String getRequestId() {
        return this.RequestId;
    }

    /**
     * 设置唯一请求ID，每次请求都会返回。定位问题时需要提供该次请求的RequestId。
     * @param RequestId 唯一请求ID，每次请求都会返回。定位问题时需要提供该次请求的RequestId。
     */
    public void setRequestId(String RequestId) {
        this.RequestId = RequestId;
    }

    /**
     * 内部实现，用户禁止调用
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamSimple(map, prefix + "SessionUuid", this.SessionUuid);
        this.setParamSimple(map, prefix + "RecognizeStatus", this.RecognizeStatus);
        this.setParamSimple(map, prefix + "SourceText", this.SourceText);
        this.setParamSimple(map, prefix + "TargetText", this.TargetText);
        this.setParamSimple(map, prefix + "Seq", this.Seq);
        this.setParamSimple(map, prefix + "Source", this.Source);
        this.setParamSimple(map, prefix + "Target", this.Target);
        this.setParamSimple(map, prefix + "RequestId", this.RequestId);

    }
}

