package 结构型模式;

public class 适配器模式 {
//    适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。
//    这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举个真实的例子，读卡器是作为内存卡和笔记本之间的适配器。
//    您将内存卡插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。
//    意图：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。


    // 为媒体播放器和更高级的媒体播放器创建接口。
    interface MediaPlayer {
        public void play(String audioType, String fileName);
    }

    interface AdvancedMediaPlayer {
        public void playVlc(String fileName);
        public void playMp4(String fileName);
    }

    // 创建实现了 AdvancedMediaPlayer 接口的实体类。
    class VlcPlayer implements AdvancedMediaPlayer{
        @Override
        public void playVlc(String fileName) {
            System.out.println("Playing vlc file. Name: "+ fileName);
        }

        @Override
        public void playMp4(String fileName) {
            //什么也不做
        }
    }

    class Mp4Player implements AdvancedMediaPlayer{

        @Override
        public void playVlc(String fileName) {
            //什么也不做
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Playing mp4 file. Name: "+ fileName);
        }
    }

    // 创建实现了 MediaPlayer 接口的适配器类。
    class MediaAdapter implements MediaPlayer {

        AdvancedMediaPlayer advancedMusicPlayer;

        public MediaAdapter(String audioType){
            if(audioType.equalsIgnoreCase("vlc") ){
                advancedMusicPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")){
                advancedMusicPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("vlc")){
                advancedMusicPlayer.playVlc(fileName);
            }else if(audioType.equalsIgnoreCase("mp4")){
                advancedMusicPlayer.playMp4(fileName);
            }
        }
    }

    // 创建实现了 MediaPlayer 接口的实体类。
    class AudioPlayer implements MediaPlayer {
        MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {

            //播放 mp3 音乐文件的内置支持
            if(audioType.equalsIgnoreCase("mp3")){
                System.out.println("Playing mp3 file. Name: "+ fileName);
            }
            //mediaAdapter 提供了播放其他文件格式的支持
            else if(audioType.equalsIgnoreCase("vlc")
                    || audioType.equalsIgnoreCase("mp4")){
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            }
            else{
                System.out.println("Invalid media. "+
                        audioType + " format not supported");
            }
        }
    }

    // 来播放不同类型的音频格式。
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new 适配器模式().new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
