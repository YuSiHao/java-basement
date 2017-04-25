package manageCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Countries {
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	private List<String> names = Arrays.asList("China American English Bonston Shanghai Africa".split(" "));
}
