package org.eclipse.qvto.examples.xtext.qvtoperational.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvto.examples.xtext.qvtoperational.services.QVTOperationalGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class QVTOperationalSyntacticSequencer extends AbstractSyntacticSequencer {

	protected QVTOperationalGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ClassifierCS_SemicolonKeyword_5_0_or___LeftCurlyBracketKeyword_5_1_0_RightCurlyBracketKeyword_5_1_2_SemicolonKeyword_5_1_3_q__;
	protected AbstractElementAlias match_ClassifierCS_SemicolonKeyword_5_1_1_2_q;
	protected AbstractElementAlias match_ClassifierCS_SemicolonKeyword_5_1_3_q;
	protected AbstractElementAlias match_EnumerationCS_SemicolonKeyword_2_1_3_q;
	protected AbstractElementAlias match_MetamodelCS_SemicolonKeyword_2_0_or___LeftCurlyBracketKeyword_2_1_0_RightCurlyBracketKeyword_2_1_2_SemicolonKeyword_2_1_3_q__;
	protected AbstractElementAlias match_MetamodelCS_SemicolonKeyword_2_1_3_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (QVTOperationalGrammarAccess) access;
		match_ClassifierCS_SemicolonKeyword_5_0_or___LeftCurlyBracketKeyword_5_1_0_RightCurlyBracketKeyword_5_1_2_SemicolonKeyword_5_1_3_q__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getClassifierCSAccess().getLeftCurlyBracketKeyword_5_1_0()), new TokenAlias(false, false, grammarAccess.getClassifierCSAccess().getRightCurlyBracketKeyword_5_1_2()), new TokenAlias(false, true, grammarAccess.getClassifierCSAccess().getSemicolonKeyword_5_1_3())), new TokenAlias(false, false, grammarAccess.getClassifierCSAccess().getSemicolonKeyword_5_0()));
		match_ClassifierCS_SemicolonKeyword_5_1_1_2_q = new TokenAlias(false, true, grammarAccess.getClassifierCSAccess().getSemicolonKeyword_5_1_1_2());
		match_ClassifierCS_SemicolonKeyword_5_1_3_q = new TokenAlias(false, true, grammarAccess.getClassifierCSAccess().getSemicolonKeyword_5_1_3());
		match_EnumerationCS_SemicolonKeyword_2_1_3_q = new TokenAlias(false, true, grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_2_1_3());
		match_MetamodelCS_SemicolonKeyword_2_0_or___LeftCurlyBracketKeyword_2_1_0_RightCurlyBracketKeyword_2_1_2_SemicolonKeyword_2_1_3_q__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getMetamodelCSAccess().getLeftCurlyBracketKeyword_2_1_0()), new TokenAlias(false, false, grammarAccess.getMetamodelCSAccess().getRightCurlyBracketKeyword_2_1_2()), new TokenAlias(false, true, grammarAccess.getMetamodelCSAccess().getSemicolonKeyword_2_1_3())), new TokenAlias(false, false, grammarAccess.getMetamodelCSAccess().getSemicolonKeyword_2_0()));
		match_MetamodelCS_SemicolonKeyword_2_1_3_q = new TokenAlias(false, true, grammarAccess.getMetamodelCSAccess().getSemicolonKeyword_2_1_3());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ClassifierCS_SemicolonKeyword_5_0_or___LeftCurlyBracketKeyword_5_1_0_RightCurlyBracketKeyword_5_1_2_SemicolonKeyword_5_1_3_q__.equals(syntax))
				emit_ClassifierCS_SemicolonKeyword_5_0_or___LeftCurlyBracketKeyword_5_1_0_RightCurlyBracketKeyword_5_1_2_SemicolonKeyword_5_1_3_q__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ClassifierCS_SemicolonKeyword_5_1_1_2_q.equals(syntax))
				emit_ClassifierCS_SemicolonKeyword_5_1_1_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ClassifierCS_SemicolonKeyword_5_1_3_q.equals(syntax))
				emit_ClassifierCS_SemicolonKeyword_5_1_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumerationCS_SemicolonKeyword_2_1_3_q.equals(syntax))
				emit_EnumerationCS_SemicolonKeyword_2_1_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MetamodelCS_SemicolonKeyword_2_0_or___LeftCurlyBracketKeyword_2_1_0_RightCurlyBracketKeyword_2_1_2_SemicolonKeyword_2_1_3_q__.equals(syntax))
				emit_MetamodelCS_SemicolonKeyword_2_0_or___LeftCurlyBracketKeyword_2_1_0_RightCurlyBracketKeyword_2_1_2_SemicolonKeyword_2_1_3_q__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MetamodelCS_SemicolonKeyword_2_1_3_q.equals(syntax))
				emit_MetamodelCS_SemicolonKeyword_2_1_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('{' '}' ';'?) | ';'
	 */
	protected void emit_ClassifierCS_SemicolonKeyword_5_0_or___LeftCurlyBracketKeyword_5_1_0_RightCurlyBracketKeyword_5_1_2_SemicolonKeyword_5_1_3_q__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_ClassifierCS_SemicolonKeyword_5_1_1_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_ClassifierCS_SemicolonKeyword_5_1_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_EnumerationCS_SemicolonKeyword_2_1_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';' | ('{' '}' ';'?)
	 */
	protected void emit_MetamodelCS_SemicolonKeyword_2_0_or___LeftCurlyBracketKeyword_2_1_0_RightCurlyBracketKeyword_2_1_2_SemicolonKeyword_2_1_3_q__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_MetamodelCS_SemicolonKeyword_2_1_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
