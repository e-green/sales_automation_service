package io.egreen.erp.transaction.service;

import io.egreen.apistudio.bootstrap.utill.IDUtilty;
import io.egreen.erp.payment.data.dao.PaymentDAO;
import io.egreen.erp.payment.data.entity.PaymentModel;
import io.egreen.erp.transaction.data.dao.TransactionDAO;
import io.egreen.erp.transaction.data.entity.TransactionModel;
import org.hashids.Hashids;
import org.jboss.weld.logging.UtilLogger;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Copyright (c) E-Green. (http://www.egreen.io) All Rights Reserved.
 * <p>
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * <p>
 * Created by dewmal on 9/3/16.
 */

public class TransactionService {

    IDUtilty idUtilty = new IDUtilty();

    @Inject
    private TransactionDAO transactionDAO;
    @Inject
    private PaymentDAO paymentDAO;


    public boolean createGSNOrderTransaction(String orderId, double amount, String typeId) {
        String transId = idUtilty.getKey(System.nanoTime());
        List<PaymentModel> models = paymentDAO.getPaymentByOrderId(orderId);
        String payId = null;
        double totle = 0;
        for (PaymentModel paymentModel : models) {
            payId = paymentModel.getPayId();
            totle = paymentModel.getAmount();
        }
        if (totle >= amount) {
            List<TransactionModel> list = transactionDAO.checkTransaction(orderId, payId);
            if (list == null || list.isEmpty() || list.size() < 0) {
                TransactionModel transactionModel = new TransactionModel();
                transactionModel.setTransId(transId);
                transactionModel.setOrderId(orderId);
                transactionModel.setPayId(payId);
                transactionModel.setTransId(typeId);
                transactionModel.setPayAmount(amount);
                transactionModel.setBalance(amount);
                transactionModel.setTransactionTime(new Date());
                transactionDAO.create(transactionModel);
                return true;
            } else if (list.size() > 0) {
                double balance = 0;
                for (TransactionModel transactionModel : list) {
                    balance = transactionModel.getBalance() + amount;
                }
                if (totle >= balance) {
                    if (balance != amount || balance == amount) {
                        TransactionModel transactionModel = new TransactionModel();
                        transactionModel.setTransId(transId);
                        transactionModel.setOrderId(orderId);
                        transactionModel.setPayId(payId);
                        transactionModel.setTransId(typeId);
                        transactionModel.setPayAmount(amount);
                        transactionModel.setBalance(balance);
                        transactionModel.setTransactionTime(new Date());
                        transactionDAO.create(transactionModel);
                        if (totle == balance) {
                            checkStatus(payId);
                        }
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private void checkStatus(String payId) {
        List<PaymentModel> modelList = paymentDAO.searchPayment(payId);
        PaymentModel paymentModel = null;
        for (PaymentModel model : modelList) {
            paymentModel = model;
        }
        paymentModel.setStatus("finished");
        paymentDAO.updatePaymentStatus(paymentModel);
    }
}
