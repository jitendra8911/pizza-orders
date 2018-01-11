package com.challenge.bootstrap;

import com.challenge.utility.OrdersUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BootstrapEntityUnitTest {

    @Mock
    private com.challenge.utility.OrdersUtility OrdersUtility;

    @InjectMocks
    BootstrapEntity bootstrapEntity = new BootstrapEntity();

    @Test
    public void testBootStrapOrders() {
        bootstrapEntity.bootStrapOrders(Mockito.anyString());
        Mockito.verify(OrdersUtility, Mockito.times(1)).readOrders(Mockito.anyString());
    }

}


