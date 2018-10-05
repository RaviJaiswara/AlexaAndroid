package com.willblaschko.android.alexa.data;

import android.media.Image;
import android.text.TextUtils;

import java.util.List;

/**
 * A catch-all Directive to classify return responses from the Amazon Alexa v20160207 API
 * Will handle calls to:
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/speechrecognizer">Speech Recognizer</a>
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/alerts">Alerts</a>
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/audioplayer">Audio Player</a>
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/playbackcontroller">Playback Controller</a>
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/speaker">Speaker</a>
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/speechsynthesizer">Speech Synthesizer</a>
 * <a href="https://developer.amazon.com/public/solutions/alexa/alexa-voice-service/reference/system">System</a>
 *
 *
 * @author wblaschko on 5/6/16.
 */
public class Directive {
    private Header header;
    private Payload payload;

    public static final String TYPE_SPEAK = "Speak";
    public static final String TYPE_PLAY = "Play";
    public static final String TYPE_STOP = "Stop";
    public static final String TYPE_STOP_CAPTURE = "StopCapture";
    public static final String TYPE_SET_ALERT = "SetAlert";
    public static final String TYPE_DELETE_ALERT = "DeleteAlert";
    public static final String TYPE_SET_VOLUME = "SetVolume";
    public static final String TYPE_ADJUST_VOLUME = "AdjustVolume";
    public static final String TYPE_SET_MUTE = "SetMute";
    public static final String TYPE_EXPECT_SPEECH = "ExpectSpeech";
    public static final String TYPE_MEDIA_PLAY = "PlayCommandIssued";
    public static final String TYPE_MEDIA_PAUSE = "PauseCommandIssued";
    public static final String TYPE_MEDIA_NEXT = "NextCommandIssued";
    public static final String TYPE_MEDIA_PREVIOUS = "PreviousCommandIssue";
    public static final String TYPE_EXCEPTION = "Exception";
    public static final String TYPE_RENDER_TEMPLATE = "RenderTemplate";
    public static final String TYPE_SET_ENDPOINT = "SetEndpoint";

    private static final String PLAY_BEHAVIOR_REPLACE_ALL = "REPLACE_ALL";
    private static final String PLAY_BEHAVIOR_ENQUEUE = "ENQUEUE";
    private static final String PLAY_BEHAVIOR_REPLACE_ENQUEUED = "REPLACE_ENQUEUED";


    //PLAY BEHAVIORS

    public boolean isPlayBehaviorReplaceAll(){
        return TextUtils.equals(payload.getPlayBehavior(), PLAY_BEHAVIOR_REPLACE_ALL);
    }
    public boolean isPlayBehaviorEnqueue(){
        return TextUtils.equals(payload.getPlayBehavior(), PLAY_BEHAVIOR_ENQUEUE);
    }
    public boolean isPlayBehaviorReplaceEnqueued(){
        return TextUtils.equals(payload.getPlayBehavior(), PLAY_BEHAVIOR_REPLACE_ENQUEUED);
    }


    public Header getHeader() {
        return header;
    }

    public Payload getPayload() {
        return payload;
    }

    public static class Header{
        String namespace;
        String name;
        String messageId;
        String dialogRequestId;

        public String getNamespace() {
            return namespace;
        }

        public String getName() {
            return name;
        }

        public String getMessageId() {
            return messageId;
        }

        public String getDialogRequestId() {
            return dialogRequestId;
        }
    }
    public static class Payload {
        String url;
        String endpoint;
        String format;
        String token;
        String type;
        String scheduledTime;
        String playBehavior;
        AudioItem audioItem;
        String volume;
        String mute;
        String timeoutInMilliseconds;
        String description;
        String code;
        Title title;
        SkillIcon skillIcon;
        String textField;
        Image image;
        ListItems[] listItems;
        String currentWeather;
        SkillIcon currentWeatherIcon;
        Temperature highTemperature;
        Temperature lowTemperature;
        WeatherForecast[] weatherForecast;
        String persistVisualIndicator;
        String playAudioIndicator;
        Asset asset;

        String audioItemId;
        Content content;
        Controls[] controls;

        Assets[] assets;
        List<String> assetPlayOrder;
        String backgroundAlertAsset;
        String loopCount;
        String loopPauseInMilliSeconds;
        String label;

        public Title getTitle() {
            return title;
        }

        public SkillIcon getSkillIcon() {
            return skillIcon;
        }

        public Image getImage() {
            return image;
        }

        public ListItems[] getListItems() {
            return listItems;
        }

        public String getCurrentWeather() {
            return currentWeather;
        }

        public SkillIcon getCurrentWeatherIcon() {
            return currentWeatherIcon;
        }

        public Temperature getHighTemperature() {
            return highTemperature;
        }

        public Temperature getLowTemperature() {
            return lowTemperature;
        }

        public WeatherForecast[] getWeatherForecast() {
            return weatherForecast;
        }

        public String getTextField() {
            return textField;
        }

        public String getUrl() {
            return url;
        }

        public String getFormat() {
            return format;
        }

        public String getToken() {
            if (token == null) {
                //sometimes we need to return the stream tokens, not the top level tokens
                if (audioItem != null && audioItem.getStream() != null) {
                    return audioItem.getStream().getToken();
                }
            }
            return token;
        }

        public String getType() {
            return type;
        }

        public String getScheduledTime() {
            return scheduledTime;
        }

        public String getPlayBehavior() {
            return playBehavior;
        }

        public AudioItem getAudioItem() {
            return audioItem;
        }

        public String getVolume() {
            return volume;
        }

        public String isMute() {
            return mute;
        }

        public String getTimeoutInMilliseconds() {
            return timeoutInMilliseconds;
        }

        public String getDescription() {
            return description;
        }

        public String getCode() {
            return code;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public String getPersistVisualIndicator() {
            return persistVisualIndicator;
        }

        public String getPlayAudioIndicator() {
            return playAudioIndicator;
        }

        public Asset getAsset() {
            return asset;
        }

        public String getAudioItemId() {
            return audioItemId;
        }

        public Content getContent() {
            return content;
        }

        public Controls[] getControls() {
            return controls;
        }

        public Assets[] getAssets() {
            return assets;
        }

        public List<String> getAssetPlayOrder() {
            return assetPlayOrder;
        }

        public String getBackgroundAlertAsset() {
            return backgroundAlertAsset;
        }

        public String getLoopCount() {
            return loopCount;
        }

        public String getLoopPauseInMilliSeconds() {
            return loopPauseInMilliSeconds;
        }

        public String getLabel() {
            return label;
        }
    }
    public class Title {
        private String subTitle;

        private String mainTitle;

        public String getSubTitle() {
            return subTitle;
        }

        public String getMainTitle() {
            return mainTitle;
        }
    }
    public class SkillIcon {

        private String contentDescription;

        private Sources[] sources;

        public String getContentDescription() {
            return contentDescription;
        }

        public Sources[] getSources() {
            return sources;
        }

    }
    public class Image {

        private String contentDescription;

        private Sources[] sources;

        public String getContentDescription() {
            return contentDescription;
        }

        public Sources[] getSources() {
            return sources;
        }

    }
    public class ListItems {
        private String leftTextField;
        private String rightTextField;

        public String getLeftTextField() {
            return leftTextField;
        }

        public String getRightTextField() {
            return rightTextField;
        }
    }
    public class Content {
        private String titleSubtext2;
        private String titleSubtext1;
        private String title;
        private Image art;
        private Provider provider;
        private String headerSubtext1;
        private long mediaLengthInMilliseconds;
        private String header;

        public String getTitleSubtext2() {
            return titleSubtext2;
        }

        public String getTitleSubtext1() {
            return titleSubtext1;
        }

        public String getTitle() {
            return title;
        }

        public Image getArt() {
            return art;
        }

        public Provider getProvider() {
            return provider;
        }

        public String getHeaderSubtext1() {
            return headerSubtext1;
        }

        public long getMediaLengthInMilliseconds() {
            return mediaLengthInMilliseconds;
        }

        public String getHeader() {
            return header;
        }
    }

    public class Provider {
        private Image logo;
        private String name;

        public Image getLogo() {
            return logo;
        }

        public String getName() {
            return name;
        }
    }

    public class Controls {
        private boolean enabled;
        private boolean selected;
        private String name;
        private String type;

        public boolean getEnabled() {
            return enabled;
        }

        public boolean getSelected() {
            return selected;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }

    public class Assets {
        private String assetId;
        private String url;

        public String getAssetId() {
            return assetId;
        }

        public String getUrl() {
            return url;
        }
    }

    public class Temperature {
        private String value;
        private Image arrow;

        public String getValue() {
            return value;
        }

        public Image getArrow() {
            return arrow;
        }
    }

    public class WeatherForecast {
        private Image image;
        private String day;
        private String date;
        private String highTemperature;
        private String lowTemperature;

        public Image getImage() {
            return image;
        }

        public String getDay() {
            return day;
        }

        public String getDate() {
            return date;
        }

        public String getHighTemperature() {
            return highTemperature;
        }

        public String getLowTemperature() {
            return lowTemperature;
        }
    }

    public class Asset {
        private String assetId;
        private String url;

        public String getAssetId() {
            return assetId;
        }

        public String getUrl() {
            return url;
        }
    }
    public class Sources {
        private String heightPixels;

        private String widthPixels;

        private String darkBackgroundUrl;

        private String url;

        private String size;

        public String getHeightPixels() {
            return heightPixels;
        }

        public String getWidthPixels() {
            return widthPixels;
        }

        public String getDarkBackgroundUrl() {
            return darkBackgroundUrl;
        }

        public String getUrl() {
            return url;
        }

        public String getSize() {
            return size;
        }
    }

    /*public static class Payload{
        String url;
        String endpoint;
        String format;
        String token;
        String type;
        String scheduledTime;
        String playBehavior;
        AudioItem audioItem;
        long volume;
        boolean mute;
        long timeoutInMilliseconds;
        String description;
        String code;

        public String getUrl() {
            return url;
        }

        public String getFormat() {
            return format;
        }

        public String getToken() {
            if(token == null){
                //sometimes we need to return the stream tokens, not the top level tokens
                if(audioItem != null && audioItem.getStream() != null){
                    return audioItem.getStream().getToken();
                }
            }
            return token;
        }

        public String getType() {
            return type;
        }

        public String getScheduledTime() {
            return scheduledTime;
        }

        public String getPlayBehavior() {
            return playBehavior;
        }

        public AudioItem getAudioItem() {
            return audioItem;
        }

        public long getVolume() {
            return volume;
        }

        public boolean isMute(){
            return mute;
        }

        public long getTimeoutInMilliseconds(){ return timeoutInMilliseconds; }

        public String getDescription() {
            return description;
        }

        public String getCode() {
            return code;
        }

        public String getEndpoint() {
            return endpoint;
        }
    }*/

    public static class AudioItem{
        String audioItemId;
        Stream stream;

        public String getAudioItemId() {
            return audioItemId;
        }

        public Stream getStream() {
            return stream;
        }
    }
    public static class Stream{
        String url;
        String streamFormat;
        long offsetInMilliseconds;
        String expiryTime;
        String token;
        String expectedPreviousToken;
        //todo progressReport


        public String getUrl() {
            return url;
        }

        public String getStreamFormat() {
            return streamFormat;
        }

        public long getOffsetInMilliseconds() {
            return offsetInMilliseconds;
        }

        public String getExpiryTime() {
            return expiryTime;
        }

        public String getToken() {
            return token;
        }

        public String getExpectedPreviousToken() {
            return expectedPreviousToken;
        }
    }

    public static class DirectiveWrapper{
        Directive directive;
        public Directive getDirective(){
            return directive;
        }
    }
}
