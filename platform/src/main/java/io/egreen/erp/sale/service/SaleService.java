package io.egreen.erp.sale.service;

import io.egreen.erp.sale.data.dao.SaleDao;
import io.egreen.erp.sale.data.dto.SaleModel;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/16/2016.
 */
public class SaleService {

    @Inject
    private SaleDao saleDao;

    public boolean newSale(SaleModel saleModel) {
        if (saleModel != null) {
            saleDao.create(saleModel);
            return true;
        }
        return false;
    }

    public List<SaleModel> getAllSales(int offset, int limit) {
        return saleDao.getAll(offset, limit);
    }
}

