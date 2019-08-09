package com.bkm.kys.core.parser;

import com.bkm.kys.core.qr.QrEmvTag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmvQrTextIterator implements QrTextIterator {

    private char[] emvQrText;
    private int tagIndex;

    public EmvQrTextIterator(String emvQrText) {
        this.emvQrText = emvQrText.toCharArray();
        this.tagIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return tagIndex < emvQrText.length - 5; // at least 5 char for an emv data object
    }

    @Override
    public QrEmvTag next() {
        if ( ! hasNext() )
            throw new NoSuchElementException();
        StringBuffer sb;
        String tagNo = new String(emvQrText, tagIndex, 2);
        tagIndex += 2;
        String length = new String(emvQrText, tagIndex, 2);
        tagIndex += 2;
        sb = new StringBuffer().append(tagNo).append(length);

        QrEmvTag qrEmvTag = new QrEmvTag(tagNo, length);

        int dataLength = Integer.valueOf(length);
        if ( dataLength == 1)
            qrEmvTag.setValue(String.valueOf(emvQrText[tagIndex ++]));
        else {
            String subTag = new String(emvQrText, tagIndex, 2);
            if ( "00".equals(subTag) ) { // has sub tags
                int subDataIndex = 0;
                while ( subDataIndex < dataLength) {
                    QrEmvTag subEmvTag = next();
                    qrEmvTag.addSubTag(subEmvTag);
                    subDataIndex += subEmvTag.getTagLength();
                }
            }
            else {
                qrEmvTag.setValue(new String(emvQrText, tagIndex, dataLength));
                tagIndex += dataLength;
            }
        }

        return qrEmvTag;
    }
}
