package com.bkm.kys.core.parser;

import com.bkm.kys.core.qr.QrEmvTag;

public interface QrTextIterator {

    public boolean hasNext() ;

    public QrEmvTag next() ;
}
