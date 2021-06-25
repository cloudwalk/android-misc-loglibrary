package com.example.poc2104301453.pinpadservice.commands;

import android.os.Bundle;

import com.example.poc2104301453.pinpadlibrary.ABECS;
import com.example.poc2104301453.pinpadservice.PinpadAbstractionLayer;

import java.util.concurrent.Semaphore;

import br.com.setis.sunmi.bibliotecapinpad.AcessoFuncoesPinpad;

public class CLO {
    private static final String TAG_LOGCAT = CLO.class.getSimpleName();

    private static AcessoFuncoesPinpad getPinpad() {
        return PinpadAbstractionLayer.getInstance().getPinpad();
    }

    public static Bundle clo(Bundle input)
            throws Exception {
        final Bundle[] output = { new Bundle() };
        final Semaphore[] semaphore = { new Semaphore(0, true) };

        getPinpad().close(() -> {
            output[0].putString(ABECS.RSP_ID,   ABECS.CLO);
            output[0].putInt   (ABECS.RSP_STAT, ABECS.STAT.ST_OK.ordinal());

            semaphore[0].release();
        });

        semaphore[0].acquireUninterruptibly();

        return output[0];
    }
}