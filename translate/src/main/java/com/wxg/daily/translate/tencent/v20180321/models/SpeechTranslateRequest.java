package com.wxg.daily.translate.tencent.v20180321.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wxg.daily.translate.tencent.common.AbstractModel;

import java.util.HashMap;

public class SpeechTranslateRequest  extends AbstractModel {


    /**
    * 一段完整的语音对应一个SessionUuid
    */
    @SerializedName("SessionUuid")
    @Expose
    private String SessionUuid;

    /**
    * 音频中的语言类型，支持语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
    */
    @SerializedName("Source")
    @Expose
    private String Source;

    /**
    * 翻译目标语⾔言类型 ，支持的语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
    */
    @SerializedName("Target")
    @Expose
    private String Target;

    /**
    * pcm : 146   amr : 33554432   mp3 : 83886080
    */
    @SerializedName("AudioFormat")
    @Expose
    private Integer AudioFormat;

    /**
    * 语音分片后的第几片
    */
    @SerializedName("Seq")
    @Expose
    private Integer Seq;

    /**
    * 是否最后一片
    */
    @SerializedName("IsEnd")
    @Expose
    private Integer IsEnd;

    /**
    * 语音分片内容的base64字符串
    */
    @SerializedName("Data")
    @Expose
    private String Data;

    /**
    * 项目id
    */
    @SerializedName("ProjectId")
    @Expose
    private Integer ProjectId;

    /**
     * 获取一段完整的语音对应一个SessionUuid
     * @return SessionUuid 一段完整的语音对应一个SessionUuid
     */
    public String getSessionUuid() {
        return this.SessionUuid;
    }

    /**
     * 设置一段完整的语音对应一个SessionUuid
     * @param SessionUuid 一段完整的语音对应一个SessionUuid
     */
    public void setSessionUuid(String SessionUuid) {
        this.SessionUuid = SessionUuid;
    }

    /**
     * 获取音频中的语言类型，支持语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     * @return Source 音频中的语言类型，支持语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     */
    public String getSource() {
        return this.Source;
    }

    /**
     * 设置音频中的语言类型，支持语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     * @param Source 音频中的语言类型，支持语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     */
    public void setSource(String Source) {
        this.Source = Source;
    }

    /**
     * 获取翻译目标语⾔言类型 ，支持的语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     * @return Target 翻译目标语⾔言类型 ，支持的语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     */
    public String getTarget() {
        return this.Target;
    }

    /**
     * 设置翻译目标语⾔言类型 ，支持的语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     * @param Target 翻译目标语⾔言类型 ，支持的语言列表<li> zh : 中文 </li> <li> en : 英文 </li>
     */
    public void setTarget(String Target) {
        this.Target = Target;
    }

    /**
     * 获取pcm : 146   amr : 33554432   mp3 : 83886080
     * @return AudioFormat pcm : 146   amr : 33554432   mp3 : 83886080
     */
    public Integer getAudioFormat() {
        return this.AudioFormat;
    }

    /**
     * 设置pcm : 146   amr : 33554432   mp3 : 83886080
     * @param AudioFormat pcm : 146   amr : 33554432   mp3 : 83886080
     */
    public void setAudioFormat(Integer AudioFormat) {
        this.AudioFormat = AudioFormat;
    }

    /**
     * 获取语音分片后的第几片
     * @return Seq 语音分片后的第几片
     */
    public Integer getSeq() {
        return this.Seq;
    }

    /**
     * 设置语音分片后的第几片
     * @param Seq 语音分片后的第几片
     */
    public void setSeq(Integer Seq) {
        this.Seq = Seq;
    }

    /**
     * 获取是否最后一片
     * @return IsEnd 是否最后一片
     */
    public Integer getIsEnd() {
        return this.IsEnd;
    }

    /**
     * 设置是否最后一片
     * @param IsEnd 是否最后一片
     */
    public void setIsEnd(Integer IsEnd) {
        this.IsEnd = IsEnd;
    }

    /**
     * 获取语音分片内容的base64字符串
     * @return Data 语音分片内容的base64字符串
     */
    public String getData() {
        return this.Data;
    }

    /**
     * 设置语音分片内容的base64字符串
     * @param Data 语音分片内容的base64字符串
     */
    public void setData(String Data) {
        this.Data = Data;
    }

    /**
     * 获取项目id
     * @return ProjectId 项目id
     */
    public Integer getProjectId() {
        return this.ProjectId;
    }

    /**
     * 设置项目id
     * @param ProjectId 项目id
     */
    public void setProjectId(Integer ProjectId) {
        this.ProjectId = ProjectId;
    }

    /**
     * 内部实现，用户禁止调用
     */
    public void toMap(HashMap<String, String> map, String prefix) {
        this.setParamSimple(map, prefix + "SessionUuid", this.SessionUuid);
        this.setParamSimple(map, prefix + "Source", this.Source);
        this.setParamSimple(map, prefix + "Target", this.Target);
        this.setParamSimple(map, prefix + "AudioFormat", this.AudioFormat);
        this.setParamSimple(map, prefix + "Seq", this.Seq);
        this.setParamSimple(map, prefix + "IsEnd", this.IsEnd);
        this.setParamSimple(map, prefix + "Data", this.Data);
        this.setParamSimple(map, prefix + "ProjectId", this.ProjectId);

    }
}

