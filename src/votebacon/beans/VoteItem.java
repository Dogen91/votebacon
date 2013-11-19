package votebacon.beans;

public class VoteItem {

	private int votes = 0;

	private int posVotes = 0;

	// TODO pforster: what is the exact vote? score or effectiveVote?
	
	public int voteUp() {
		this.votes++;
		this.posVotes++;

		return getScore();
	}

	public int voteDown() {
		this.votes++;

		return getScore();
	}

	// returns the "real score"
	public int getScore() {
		if (this.votes == 0) {
			return 0;
		} else {
			return this.posVotes / this.votes;
		}
	}

	// returns a simple positive-negative votes number
	public int getEffectiveVotes() {
		return this.getPosVotes() - (this.getVotes() - this.getPosVotes());
	}

	public int getPosVotes() {
		return posVotes;
	}

	public void setPosVotes(int posVotes) {
		this.posVotes = posVotes;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
}
