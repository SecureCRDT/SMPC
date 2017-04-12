package pt.uminho.haslab.smhbase.sharmind.batch;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pt.uminho.haslab.smhbase.exceptions.InvalidNumberOfBits;
import pt.uminho.haslab.smhbase.exceptions.InvalidSecretValue;
import pt.uminho.haslab.smhbase.interfaces.Players;
import pt.uminho.haslab.smhbase.sharmind.helpers.BatchDbTest;
import pt.uminho.haslab.smhbase.sharmind.helpers.TestPlayer;
import pt.uminho.haslab.smhbase.sharmind.helpers.TestPlayers;

@RunWith(Parameterized.class)
public abstract class BatchProtocolTest {
	protected final int nbits;

	public BatchProtocolTest(int nbits) {
		this.nbits = nbits;
	}

	public Players setupPlayers() {

		TestPlayers players = new TestPlayers(3);

		TestPlayer p0 = new TestPlayer(0, players);
		TestPlayer p1 = new TestPlayer(1, players);
		TestPlayer p2 = new TestPlayer(2, players);

		players.addPlayer(p0);
		players.addPlayer(p1);
		players.addPlayer(p2);

		return players;
	}

	/*
	 * Has to return a list with three DbTest.
	 */
	public abstract List<BatchDbTest> prepareDatabases(Players players)
			throws InvalidNumberOfBits, InvalidSecretValue;

	/*
	 * Must contain the assert statement.
	 */
	public abstract void condition(BatchDbTest db1, BatchDbTest db2,
			BatchDbTest db3);

	@Test
	public void protocol() throws InterruptedException, InvalidNumberOfBits,
			InvalidSecretValue {
		Players players = setupPlayers();
		List<BatchDbTest> workers = prepareDatabases(players);

		BatchDbTest rdb0 = workers.get(0);
		BatchDbTest rdb1 = workers.get(1);
		BatchDbTest rdb2 = workers.get(2);

		rdb0.start();
		rdb1.start();
		rdb2.start();

		rdb0.join();
		rdb1.join();
		rdb2.join();

		condition(rdb0, rdb1, rdb2);

	}
}