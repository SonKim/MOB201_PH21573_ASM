package com.example.assignment;

import android.util.Log;

import com.example.assignment.model.Tin1;
import com.example.assignment.model.Tin2;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TinTucLoader2 {
    List<Tin2> tinTucList = new ArrayList<>();
    Tin2 tinTuc;
    String textContent;

    public List<Tin2> getTinTucList(InputStream inputStream) {
        // nội dung tự viết , tham khảo ví dụ product
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            // truyền nguồn dữ liệu
            parser.setInput(inputStream, null);
            // xác định event type
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // viết code xử lý ở đây
                String tagName = parser.getName();
                Log.d("zzzzz", "Tag name =  " + tagName +
                        ", Độ sâu của thẻ = " + parser.getDepth() + ", event = " + eventType);


                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        // bắt đầu vào 1 thẻ
                        if (tagName.equalsIgnoreCase("item")) {
                            tinTuc = new Tin2();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tinTuc != null) {
                            //
                            if (tagName.equalsIgnoreCase("item")) {
                                tinTucList.add(tinTuc);
                            }

                            if (tagName.equalsIgnoreCase("title")) {
                                tinTuc.setTitle(textContent);
                            }

                            if (tagName.equalsIgnoreCase("description")) {
                                tinTuc.setDescription(textContent);
                            }
                            if (tagName.equalsIgnoreCase("link")) {
                                tinTuc.setLink(textContent);
                            }
                        }


                        break;
                    default:
                        Log.d("zzzz", "eventType khác: " + eventType + ", tag = " + tagName);
                        break;
                }


                // viết lệnh chuyển event type để vòng lặp không bị treo
                // để ở cuối cùng của lệnh while
                eventType = parser.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tinTucList;
    }
}
