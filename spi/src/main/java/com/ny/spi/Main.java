package com.ny.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {


    public static void main(String[] args) {
        IOperation plus = new PlusOperationImpl();
        System.out.println(plus.operation(1, 2));

        //
        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> operationIterator = operations.iterator();
        System.out.println("classPath:"+System.getProperty("java.class.path"));
        while (operationIterator.hasNext()) {
            IOperation operation = operationIterator.next();
            System.out.println(operation.operation(6, 3));
        }
    }
}
