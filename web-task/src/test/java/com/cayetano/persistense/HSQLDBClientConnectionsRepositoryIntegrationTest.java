package com.cayetano.persistense;

import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfigurations.class})
public class HSQLDBClientConnectionsRepositoryIntegrationTest {

    @Autowired
    private ClientConnectionsRepository repository;

    @Test
    public void returnsWhatWasSavedOfClientConnections() {

        ClientConnectionEntity entity = new ClientConnectionEntity();
        repository.saveConnection(entity);
        assertThat(repository.getConnections().size(), is(1));

    }


    @Test
    public void emptyListIsReturnedWhenNoClientConnectionIsSaved() {
        assertThat(repository.getConnections().size(), is(0));
    }


    @Test
    public void returnsClientConnectionsBetweenTwoDates() {

        ClientConnectionEntity entity1 = new ClientConnectionEntity();
        entity1.setConnectionTime(1l);
        entity1.setClientBrowser("1");

        ClientConnectionEntity entity2 = new ClientConnectionEntity();
        entity2.setConnectionTime(2l);
        entity2.setClientBrowser("2");

        ClientConnectionEntity entity3 = new ClientConnectionEntity();
        entity3.setConnectionTime(2l);
        entity3.setClientBrowser("2");


        ClientConnectionEntity entity4 = new ClientConnectionEntity();
        entity4.setConnectionTime(4l);
        entity4.setClientBrowser("4");


        repository.saveConnection(entity1);
        repository.saveConnection(entity2);
        repository.saveConnection(entity3);
        repository.saveConnection(entity4);

        assertThat(repository.getConnections().size(),is(4));

        List<ClientConnectionEntity> expected =  repository.getConnectionBetween(2l, 4l);

        assertThat(expected.size(), is(3));

    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date;
    }

}