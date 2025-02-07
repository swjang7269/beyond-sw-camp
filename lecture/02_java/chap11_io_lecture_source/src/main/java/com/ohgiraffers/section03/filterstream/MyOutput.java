package com.ohgiraffers.section03.filterstream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// 헤더 충돌을 막기 위한 보조 스트림(output stream) 생성
/* 설명. 우리만의 헤더 추가가 안되는 ObjectOutputStream */
public class MyOutput extends ObjectOutputStream {
    public MyOutput(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        /* 설명. 객체를 파일로 출력할 시 헤더의 개념이 추가되지 않도록 기능 삭제 */
    }
}
