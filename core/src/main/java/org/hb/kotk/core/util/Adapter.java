/**
 * 
 */
package org.hb.kotk.core.util;

/**
 * @author neil
 * 
 */
public interface Adapter
{
	Object selectNumOfPlayer(String opts);

	Object assignAI(String opts);

	Object selectRole(String opts);

	Object selectHero(String opts);

	Object pickTarget(String opts);

	Object pickTarget2(String opts);

	Object pickTargetCard(String opts);

	Object guessTargetCardColor(String opts);
}
