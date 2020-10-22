package com.infocube.expense.firebase;

public interface FirebaseObserver<T> {
    void onChanged(T t);
}
