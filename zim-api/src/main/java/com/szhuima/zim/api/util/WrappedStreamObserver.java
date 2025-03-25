package com.szhuima.zim.api.util;

import io.grpc.stub.StreamObserver;
import java.util.concurrent.atomic.AtomicBoolean;

// 自定义 StreamObserver 包装类
public class WrappedStreamObserver<T> implements StreamObserver<T> {
    private final StreamObserver<T> delegate;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);

    public WrappedStreamObserver(StreamObserver<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void onNext(T value) {
        if (!isClosed.get()) {
            delegate.onNext(value);
        }
    }

    @Override
    public void onError(Throwable t) {
        if (isClosed.compareAndSet(false, true)) {
            delegate.onError(t);
        }
    }

    @Override
    public void onCompleted() {
        if (isClosed.compareAndSet(false, true)) {
            delegate.onCompleted();
        }
    }

    // 判断流是否关闭的方法
    public boolean isClosed() {
        return isClosed.get();
    }
}