package com.bkm.kys.core.qr;

import java.util.ArrayList;
import java.util.List;

public class QrEmvTag {

    private String tagNo;
    private String length;
    private String value;
    private List<QrEmvTag> subTagList;

    private String emvQrDataObject(String tag, String value) {
        StringBuffer sb = new StringBuffer();
        String tagNo = QrTagMap.getEmvQrTagNoByName(tag);

        sb.append(tagNo);
        sb.append(value.length());
        sb.append(value);

        return sb.toString();
    }

    public QrEmvTag(String tagNo, String length){
        this.tagNo = tagNo;
        this.length = length;
    }

    public int getTagLength(){
        int length = 2 + 2 + value.length();
        return length;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<QrEmvTag> getSubTagList() {
        return subTagList;
    }

    public void addSubTag(QrEmvTag subTag) {
        if ( subTagList == null )
            subTagList = new ArrayList<QrEmvTag>();

        subTagList.add(subTag);
    }

    @Override
    public String toString() {
        return "QrEmvTag{" +
                "tagNo='" + tagNo + '\'' +
                ", length='" + length + '\'' +
                ", value='" + value + '\'' +
                ", subTagList=" + subTagList +
                '}';
    }
}
