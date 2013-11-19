package votebacon.beans;

public class VoteItem implements Comparable<VoteItem> {

	private int votes = 0;
	private int posVotes = 0;

	public int voteUp( User user ) {
		if ( user != null ) {
			this.votes++;
			this.posVotes++;
		}
		return getEffectiveVotes();
	}

	public int voteDown( User user ) {
		if ( user != null ) {
			this.votes++;
		}
		return getEffectiveVotes();
	}

	/** 
	 * returns the "real score"
	 * @return double
	 * @author PCHR
	 */
	public double getScore() {
		if ( this.getVotes() == 0 ) {
			return 0.0;
		} else {
			return (double) this.getPosVotes() / (double) this.getVotes();
		}
	}
	
	/**
	 * returns a simple positive-negative votes number
	 * @return int
	 * @author PCHR
	 */
	public int getEffectiveVotes() {
		return this.getPosVotes() - ( this.getVotes() - this.getPosVotes() );
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
	
	/**
	 * Implement compareTo-Method to be able to sort the voteItems.
	 * 1st factor is the score. If the score is the same, look at the total amount of votes.
	 * 
	 * @param VoteItem o VoteItem to compare this VoteItem to.
	 * @return int
	 * @author PCHR
	 */
	@Override
	public int compareTo( VoteItem o ) {
		if ( o instanceof VoteItem ) {
	        VoteItem otherVoteItem = (VoteItem) o;
	        if ( this.getScore() < otherVoteItem.getScore() ) {
	        	return -1;
	        } else if ( this.getScore() > otherVoteItem.getScore() ) {
	        	return 1;
	        } else {
	        	// if scores are the same, prefer the one with the higher amount of votes
	        	if ( this.getVotes() < otherVoteItem.getVotes() ) {
		        	return 1;
		        } else if ( this.getVotes() > otherVoteItem.getVotes() ) {
		        	return -1;
		        } else {
		        	return 0;
		        }
	        }
	    } else {
	        return 0;
	    }
	}
}
