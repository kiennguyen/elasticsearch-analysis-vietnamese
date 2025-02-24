/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.vi.VietnameseTokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

/**
 * @author duydo
 */
public class VietnameseTokenizerFactory extends AbstractTokenizerFactory {

    private final boolean sentenceDetectorEnabled;
    private final boolean ambiguitiesResolved;

    public VietnameseTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, settings);
        sentenceDetectorEnabled = settings.getAsBoolean("sentence_detector", Boolean.FALSE);
        ambiguitiesResolved = settings.getAsBoolean("ambiguities_resolved", Boolean.FALSE);
    }

    @Override
    public Tokenizer create() {
        return new VietnameseTokenizer(sentenceDetectorEnabled, ambiguitiesResolved);
    }
}
