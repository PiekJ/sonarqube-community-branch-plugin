package com.github.mc1arke.sonarqube.plugin.ce.pullrequest.commentfilter;

import com.github.mc1arke.sonarqube.plugin.ce.pullrequest.PostAnalysisIssueVisitor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class IssueFilterRunnerTest {

    IssueFilterRunner issueFilterRunner;
    Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter1;
    Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter2;

    @Before
    public void setup(){
        filter1 = mock(SeverityExclusionFilter.class);
        when(filter1.and(any())).thenCallRealMethod();
        when(filter1.test(any())).thenReturn(true);
        filter2 = mock(TypeExclusionFilter.class);
        when(filter2.test(any())).thenReturn(true);
        List<Predicate<PostAnalysisIssueVisitor.ComponentIssue>> filterList = Arrays.asList(filter1, filter2);

        SeverityComparator severityComparator = mock(SeverityComparator.class);
        when(severityComparator.compare(any(),any())).thenReturn(0);
        when(severityComparator.thenComparing(any(TypeComparator.class))).thenReturn(severityComparator);
        TypeComparator typeComparator = mock(TypeComparator.class);
        when(typeComparator.compare(any(),any())).thenReturn(0);
        issueFilterRunner = new IssueFilterRunner(filterList, severityComparator,typeComparator);
    }

    @Test
    public void testFilterIssuesWithoutMaxAmountOfIssues(){
//        Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter1 = mock(SeverityExclusionFilter.class);
//        when(filter1.and(any())).thenCallRealMethod();
//        when(filter1.test(any())).thenReturn(true);
//        Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter2 = mock(TypeExclusionFilter.class);
//        when(filter2.test(any())).thenReturn(true);
//        List<Predicate<PostAnalysisIssueVisitor.ComponentIssue>> filterList = Arrays.asList(filter1, filter2);
//
//        SeverityComparator severityComparator = mock(SeverityComparator.class);
//        when(severityComparator.compare(any(),any())).thenReturn(0);
//        when(severityComparator.thenComparing(any(TypeComparator.class))).thenReturn(severityComparator);
//        TypeComparator typeComparator = mock(TypeComparator.class);
//        when(typeComparator.compare(any(),any())).thenReturn(0);
//
//        IssueFilterRunner issueFilterRunner = new IssueFilterRunner(filterList, severityComparator,typeComparator);

        List<PostAnalysisIssueVisitor.ComponentIssue> componentIssues = Arrays.asList(mock(PostAnalysisIssueVisitor.ComponentIssue.class),mock(PostAnalysisIssueVisitor.ComponentIssue.class));

        List<PostAnalysisIssueVisitor.ComponentIssue> filteredComponentIssues = issueFilterRunner.filterIssues(componentIssues);
        verify(filter1, times(2)).test(any());
        verify(filter2, times(2)).test(any());
        assertEquals(2,filteredComponentIssues.size());
    }

    @Test
    public void testFilterIssuesWithMaxAmountOfIssuesOfZero(){
//        Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter1 = mock(SeverityExclusionFilter.class);
//        when(filter1.and(any())).thenCallRealMethod();
//        when(filter1.test(any())).thenReturn(true);
//        Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter2 = mock(TypeExclusionFilter.class);
//        when(filter2.test(any())).thenReturn(true);
//        List<Predicate<PostAnalysisIssueVisitor.ComponentIssue>> filterList = Arrays.asList(filter1, filter2);
//
//        SeverityComparator severityComparator = mock(SeverityComparator.class);
//        when(severityComparator.compare(any(),any())).thenReturn(0);
//        when(severityComparator.thenComparing(any(TypeComparator.class))).thenReturn(severityComparator);
//        TypeComparator typeComparator = mock(TypeComparator.class);
//        when(typeComparator.compare(any(),any())).thenReturn(0);
//
//        IssueFilterRunner issueFilterRunner = new IssueFilterRunner(filterList,0, severityComparator,typeComparator);

        List<PostAnalysisIssueVisitor.ComponentIssue> componentIssues = Arrays.asList(mock(PostAnalysisIssueVisitor.ComponentIssue.class),mock(PostAnalysisIssueVisitor.ComponentIssue.class));

        List<PostAnalysisIssueVisitor.ComponentIssue> filteredComponentIssues = issueFilterRunner.filterIssues(componentIssues);
        verify(filter1, times(2)).test(any());
        verify(filter2, times(2)).test(any());
        assertEquals(2,filteredComponentIssues.size());
    }

    @Test
    public void testFilterIssuesWithMaxAmountOfIssuesOfOne(){
//        Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter1 = mock(SeverityExclusionFilter.class);
//        when(filter1.and(any())).thenCallRealMethod();
//        when(filter1.test(any())).thenReturn(true);
//        Predicate<PostAnalysisIssueVisitor.ComponentIssue> filter2 = mock(TypeExclusionFilter.class);
//        when(filter2.test(any())).thenReturn(true);
//        List<Predicate<PostAnalysisIssueVisitor.ComponentIssue>> filterList = Arrays.asList(filter1, filter2);
//
//        SeverityComparator severityComparator = mock(SeverityComparator.class);
//        when(severityComparator.compare(any(),any())).thenReturn(0);
//        when(severityComparator.thenComparing(any(TypeComparator.class))).thenReturn(severityComparator);
//        TypeComparator typeComparator = mock(TypeComparator.class);
//        when(typeComparator.compare(any(),any())).thenReturn(0);
//
//        IssueFilterRunner issueFilterRunner = new IssueFilterRunner(filterList,1, severityComparator,typeComparator);

        List<PostAnalysisIssueVisitor.ComponentIssue> componentIssues = Arrays.asList(mock(PostAnalysisIssueVisitor.ComponentIssue.class),mock(PostAnalysisIssueVisitor.ComponentIssue.class));

        List<PostAnalysisIssueVisitor.ComponentIssue> filteredComponentIssues = issueFilterRunner.filterIssues(componentIssues);
        verify(filter1, times(2)).test(any());
        verify(filter2, times(2)).test(any());
        assertEquals(1,filteredComponentIssues.size());
    }
}
