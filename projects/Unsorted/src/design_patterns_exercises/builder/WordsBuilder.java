package design_patterns_exercises.builder;

import java.util.Collection;

public interface WordsBuilder
{
	public void addWord( String word ) ;
	public Collection<String> getCollection() ;
}
